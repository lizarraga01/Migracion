package com.sye.mifosbatch.dao;

import com.sye.mifosbatch.entity.Cliente;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientesDAO extends CrudRepository<Cliente,Long> {


    //@Query("Select officeid,filiationid,legalformid,maritalstatusid,genderid,curp,rfc,firstname,lastname,motherlastname,sonsno,nss,phoneno,emailaddress,mobileno,activationdate,submittedondate,dateofbirth,idclientesibadac,idmifos,resourceid,migrationdesc from Cliente where idmifos = 0")
    List<Cliente> findFirst1000ByIdmifos(int idmifos);

    //@Query("Select officeid,filiationid,legalformid,maritalstatusid,genderid,curp,rfc,firstname,lastname,motherlastname,sonsno,nss,phoneno,emailaddress,mobileno,activationdate,submittedondate,dateofbirth,idclientesibadac,idmifos,resourceid,migrationdesc from Cliente where idmifos = 0")
    List<Cliente> findFirst2ByIdmifos(int idmifos);

    List<Cliente> findFirst100ByIdmifos(int idmifos);

    /*
    @Transactional
    @Query("Select officeid,filiationid,legalformid,maritalstatusid,genderid,curp,rfc,firstname,lastname,motherlastname,sonsno,nss,phoneno,emailaddress,mobileno,activationdate,submittedondate,dateofbirth,idclientesibadac,idmifos,resourceid,migrationdesc from Cliente where idmifos = 0 Limit 10", nativeQuery=true)
    List<Cliente> getPorProcesar();
    */

    @Transactional
    @Modifying
    @Query("UPDATE Cliente SET idmifos = :idmifos, officeid = :officeid,  resourceid = :resourceid, migrationdesc = :migrationdesc WHERE idclientesibadac = :idclientesibadac")
    int updateClienteSetidmifosForidclientesibadac(@Param("idmifos") int idmifos, @Param("resourceid") int resourceid, @Param("officeid") int officeid, @Param("migrationdesc") String migrationdesc, @Param("idclientesibadac") Long idclientesibadac);
    /*
    @Transactional
    @Modifying
    @Query("UPDATE Cliente SET idmifos = :idmifos WHERE idclientesibadac = :idclientesibadac")
    int updateClienteSetidmifosForidclientesibadac(@Param("idmifos") int idmifos, @Param("idclientesibadac") Long idclientesibadac);
    */
}
