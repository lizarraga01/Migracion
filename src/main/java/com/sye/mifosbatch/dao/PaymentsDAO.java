package com.sye.mifosbatch.dao;

import com.sye.mifosbatch.entity.Loan;
import com.sye.mifosbatch.entity.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentsDAO extends CrudRepository<Payment, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Payment SET clientid = :clientid, officeid = :officeid, resourceid = :resourceid,  migrationdesc = :migrationdesc, migrado=1, lastupdate=now() WHERE id = :id")
    int updateEstatusPago(@Param("clientid") Long clientid, @Param("officeid") Long officeid, @Param("resourceid") Long resourceid, @Param("migrationdesc") String migrationdesc, @Param("id") Long id);

    List<Payment> findFirst5ByMigradoAndIdcreditomifosOrderByTransactiondateAsc(int migrado, Long idcreditomifos );
    List<Payment> findFirst10000ByMigradoAndIdcreditomifosOrderByTransactiondateAsc(int idmifos, Long idcreditomifos );

}