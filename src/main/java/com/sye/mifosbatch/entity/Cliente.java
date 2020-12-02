package com.sye.mifosbatch.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="clientes")
@Data
public class Cliente implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Column(name="officeid")    
    private int officeid;
    @Column(name="filiationid")    
    private int filiationid;
    @Column(name="legalformid")    
    private int legalformid;
    @Column(name="maritalstatusid")    
    private int maritalstatusid;
    @Column(name="genderid")    
    private int genderid;
    @Column(name="curp", nullable = true)    
    private String curp;
    @Column(name="rfc", nullable = true)    
    private String rfc;
    @Column(name="firstname")    
    private String firstname;
    @Column(name="lastname")    
    private String lastname;
    @Column(name="motherlastname")    
    private String motherlastname;
    @Column(name="sonsno", nullable = true)    
    private String sonsno;
    @Column(name="nss", nullable = true)    
    private String nss;
    @Column(name="phoneno", nullable = true)    
    private String phoneno;
    @Column(name="emailaddress", nullable = true)    
    private String emailaddress;
    @Column(name="mobileno", nullable = true)    
    private String mobileno;
    @Column(name="activationdate")    
    private String activationdate;
    @Column(name="submittedondate")    
    private String submittedondate;
    @Column(name="dateofbirth")    
    private String dateofbirth;
    @Id
    @Column(name="idclientesibadac")    
    private Long idclientesibadac;  
    @Column(name="idmifos")    
    private int idmifos;
    @Column(name="resourceid")    
    private int resourceid;
    @Column(name="migrationdesc")    
    private String migrationdesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getOfficeid() {
        return officeid;
    }

    public void setOfficeid(int officeid) {
        this.officeid = officeid;
    }

    public int getFiliationid() {
        return filiationid;
    }

    public void setFiliationid(int filiationid) {
        this.filiationid = filiationid;
    }

    public int getLegalformid() {
        return legalformid;
    }

    public void setLegalformid(int legalformid) {
        this.legalformid = legalformid;
    }

    public int getMaritalstatusid() {
        return maritalstatusid;
    }

    public void setMaritalstatusid(int maritalstatusid) {
        this.maritalstatusid = maritalstatusid;
    }

    public int getGenderid() {
        return genderid;
    }

    public void setGenderid(int genderid) {
        this.genderid = genderid;
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

    public String getSonsno() {
        return sonsno;
    }

    public void setSonsno(String sonsno) {
        this.sonsno = sonsno;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getActivationdate() {
        return activationdate;
    }

    public void setActivationdate(String activationdate) {
        this.activationdate = activationdate;
    }

    public String getSubmittedondate() {
        return submittedondate;
    }

    public void setSubmittedondate(String submittedondate) {
        this.submittedondate = submittedondate;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Long getIdclientesibadac() {
        return idclientesibadac;
    }

    public void setIdclientesibadac(Long idclientesibadac) {
        this.idclientesibadac = idclientesibadac;
    }

    public int getIdmifos() {
        return idmifos;
    }

    public void setIdmifos(int idmifos) {
        this.idmifos = idmifos;
    }

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public String getMigrationdesc() {
        return migrationdesc;
    }

    public void setMigrationdesc(String migrationdesc) {
        this.migrationdesc = migrationdesc;
    }
}
