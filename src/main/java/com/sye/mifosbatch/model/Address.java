package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import com.sye.mifosbatch.entity.Direccion;

import lombok.Data;

@Data
public class Address {

    public Address(){
        this.setActive(true);
    }

    public Address(Direccion direccion) {
        this.setActive(true);
        this.setAddressTypeId(direccion.getAddresstypeid());
        this.setBetweenStreets(direccion.getBetweenstreets());
        this.setBuilding(direccion.getBuilding());
        this.setCity(direccion.getCity());
        this.setCityId(direccion.getCityid());
        this.setCountry(direccion.getCountry());
        this.setCountyDistrict(direccion.getCountrydistrict());
        this.setExtNo(direccion.getExtno());
        this.setIntNo(direccion.getIntno());
        this.setMunicipalityId(direccion.getMunicipalityid());
        this.setPostalCode(direccion.getPostalcode());
        this.setState(direccion.getState());
        this.setStateId(direccion.getStateid());
        this.setStreet(direccion.getStreet());
        this.setSuburbId(direccion.getSuburbid());
        this.setTownVillage(direccion.getTownvillage());
    }
    @Expose
    private int addressTypeId;
    @Expose
    private boolean isActive;
    @Expose
    private String street;
    @Expose
    private String betweenStreets;
    @Expose
    private String extNo;
    @Expose
    private String intNo;
    @Expose
    private String building;
    @Expose
    private String postalCode;
    @Expose
    private int suburbId;
    @Expose
    private String townVillage;
    @Expose
    private int cityId;
    @Expose
    private String city;
    @Expose
    private int municipalityId;
    @Expose
    private String countyDistrict;
    @Expose
    private int stateId;
    @Expose
    private String state;
    @Expose
    private String country;
}
