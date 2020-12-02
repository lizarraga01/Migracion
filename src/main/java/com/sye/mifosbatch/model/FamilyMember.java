package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import com.sye.mifosbatch.entity.Familiares;

import lombok.Data;

@Data
public class FamilyMember {
    
    public FamilyMember(){
        this.setActive(true);
        this.setLocale("es_MX");
        this.setDateFormat("dd/MM/yyyy");
    }

    public FamilyMember(Familiares familiares) {
        this.setActive(true);
        this.setCurp(familiares.getCurp());
        this.setDateFormat("dd/MM/yyyy");
        this.setDateOfBirth(familiares.getDateofbirth());
        this.setEmailAddress(familiares.getEmailaddress());
        this.setFirstname(familiares.getFirstname());
        this.setGenderId(familiares.getGenderid());
        this.setLastname(familiares.getLastname());
        this.setLocale("es_MX");
        this.setMaritalStatusId(familiares.getMaritalstatusid());
        this.setMobileNo(familiares.getMobileno());
        this.setMotherlastname(familiares.getMotherlastname());
        this.setNss(familiares.getNss());
        this.setPhoneNo(familiares.getPhoneno());
        this.setRelationshipId(familiares.getRelationshipid());
        this.setRfc(familiares.getRfc());
    }

    public int getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(int relationshipId) {
        this.relationshipId = relationshipId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMotherlastname() {
        return motherlastname;
    }

    public void setMotherlastname(String motherlastname) {
        this.motherlastname = motherlastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public int getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(int maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Expose
    private int relationshipId;
    @Expose
    private boolean isActive;
    @Expose
    private String curp;
    @Expose
    private String rfc;
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String motherlastname;
    @Expose
    private String dateOfBirth;
    @Expose
    private int genderId;
    @Expose
    private int maritalStatusId;
    @Expose
    private String nss;
    @Expose
    private String phoneNo;
    @Expose
    private String emailAddress;
    @Expose
    private String mobileNo;
    @Expose
    private String locale;
    @Expose
    private String dateFormat;
}
