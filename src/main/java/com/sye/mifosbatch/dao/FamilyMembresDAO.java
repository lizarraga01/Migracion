package com.sye.mifosbatch.dao;

import java.util.List;

import com.sye.mifosbatch.entity.Familiares;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FamilyMembresDAO extends CrudRepository<Familiares, Long> {
    
    @Query("FROM Familiares WHERE idclientesibadac = ?1")
    List<Familiares> findByIdclientesibadac(Long idSibadac);
}
