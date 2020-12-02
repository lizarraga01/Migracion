package com.sye.mifosbatch.dao;

import java.util.List;

import com.sye.mifosbatch.entity.Direccion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Direccion, Long> {
    
    @Query("FROM Direccion WHERE idclientesibadac = ?1")
    List<Direccion> findByIdclientesibadac(Long idSibadac);
}
