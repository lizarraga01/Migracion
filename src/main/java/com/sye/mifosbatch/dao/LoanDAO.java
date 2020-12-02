package com.sye.mifosbatch.dao;

import java.util.List;

import com.sye.mifosbatch.entity.Cliente;
import com.sye.mifosbatch.entity.Loan;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LoanDAO extends CrudRepository<Loan, Long> {
    
    @Query("FROM Loan WHERE nocreditoanterior = ?1")
    List<Loan> findByIdcreditosibadac(Long idSibadac);

    List<Loan> findFirst2ByIdmifos(int idmifos);
    List<Loan> findFirst1000ByIdmifos(int idmifos);

    @Transactional
    @Modifying
    @Query("UPDATE Loan SET idmifos = :idmifos, migrationdesc = :migrationdesc WHERE idcreditosibadac = :idcreditosibadac")
    int updateCreditoSetidmifosForidcreditosibadac(@Param("idmifos") int idmifos, @Param("migrationdesc") String migrationdesc, @Param("idcreditosibadac") Long idcreditosibadac);

}
