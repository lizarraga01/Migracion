package com.sye.mifosbatch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="address")
@Data
public class Direccion {

    @Column(name="idclientesibadac")
    private Long idclientesibadac;
    @Column(name="addresstypeid")
    private int addresstypeid;
    @Column(name="street")
    private String street;
    @Column(name="betweenstreets")
    private String betweenstreets;
    @Column(name="extno")
    private String extno;
    @Column(name="intno")
    private String intno;
    @Column(name="building")
    private String building;
    @Column(name="postalcode")
    private String postalcode;
    @Column(name="suburbid")
    private int suburbid;
    @Column(name="townvillage")
    private String townvillage;
    @Column(name="cityid")
    private int cityid;
    @Column(name="city")
    private String city;
    @Column(name="municipalityid")
    private int municipalityid;
    @Column(name="countrydistrict")
    private String countrydistrict;
    @Column(name="stateid")
    private int stateid;
    @Column(name="state")
    private String state;
    @Column(name="country")
    private String country;
    @Id
    private Long id;
    
}
