package com.sye.mifosbatch.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.sye.mifosbatch.entity.Cliente;

import lombok.Data;

@Data
public class Client {
   
    public Client(){
        this.setActive(active);
        this.setLocale("es_MX");
        this.setDateFormat("dd/MM/yyyy");
    }

    public Client(Cliente cliente) {
        this.setActive(true);
        this.setLocale("es_MX");
        this.setDateFormat("dd/MM/yyyy");
        this.setActivationDate(cliente.getActivationdate());
        this.setCurp(cliente.getCurp());
        this.setDateOfBirth(cliente.getDateofbirth());
        this.setEmailAddress(cliente.getEmailaddress());
        this.setFiliationId(cliente.getFiliationid());
        this.setFirstname(cliente.getFirstname());
        this.setGenderId(cliente.getGenderid());
        this.setLastname(cliente.getLastname());
        this.setLegalFormId(cliente.getLegalformid());
        this.setMaritalStatusId(cliente.getMaritalstatusid());
        this.setMobileNo(cliente.getMobileno());
        this.setMotherlastname(cliente.getMotherlastname());
        this.setNss(cliente.getNss());
        this.setOfficeId(cliente.getOfficeid());
        this.setPhoneNo(cliente.getPhoneno());
        this.setRfc(cliente.getRfc());
        this.setSavingsProductId("");
        this.setSonsNo(cliente.getSonsno());
        this.setSubmittedOnDate(cliente.getSubmittedondate());
        this.setIdsibadac(cliente.getIdclientesibadac());
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getFiliationId() {
        return filiationId;
    }

    public void setFiliationId(int filiationId) {
        this.filiationId = filiationId;
    }

    public int getLegalFormId() {
        return legalFormId;
    }

    public void setLegalFormId(int legalFormId) {
        this.legalFormId = legalFormId;
    }

    public int getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(int maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
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

    public String getSonsNo() {
        return sonsNo;
    }

    public void setSonsNo(String sonsNo) {
        this.sonsNo = sonsNo;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getSubmittedOnDate() {
        return submittedOnDate;
    }

    public void setSubmittedOnDate(String submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object getSavingsProductId() {
        return savingsProductId;
    }

    public void setSavingsProductId(Object savingsProductId) {
        this.savingsProductId = savingsProductId;
    }

    public Long getIdsibadac() {
        return idsibadac;
    }

    public void setIdsibadac(Long idsibadac) {
        this.idsibadac = idsibadac;
    }

    @Expose
    public List<Address> address;
    @Expose
    public List<FamilyMember> familyMembers;
    @Expose
    public int officeId;
    @Expose
    public int filiationId;
    @Expose
    public int legalFormId;
    @Expose
    public int maritalStatusId;
    @Expose
    public int genderId;
    @Expose
    public String curp;
    @Expose
    public String rfc;
    @Expose
    public String firstname;
    @Expose
    public String lastname;
    @Expose
    public String motherlastname;
    @Expose
    public String sonsNo;
    @Expose
    public String nss;
    @Expose
    public String phoneNo;
    @Expose
    public String emailAddress;
    @Expose
    public String mobileNo;
    @Expose
    public boolean active;
    @Expose
    public String locale;
    @Expose
    public String dateFormat;
    @Expose
    public String activationDate;
    @Expose
    public String submittedOnDate;
    @Expose
    public String dateOfBirth;
    @Expose
    public Object savingsProductId;

    private Long idsibadac;
}
