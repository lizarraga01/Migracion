package com.sye.mifosbatch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="familymembers")
@Data
public class Familiares {

    @Column(name="idclientesibadac", nullable = false)
    private Long idclientesibadac;
    @Column(name="relationshipid")  
    private int relationshipid;
    @Column(name="curp")  
    private String curp;
    @Column(name="rfc")  
    private String rfc;
    @Column(name="firstname")  
    private String firstname;
    @Column(name="lastname")  
    private String lastname;
    @Column(name="motherlastname")  
    private String motherlastname;
    @Column(name="dateofbirth")  
    private String dateofbirth;
    @Column(name="genderid")  
    private int genderid;
    @Column(name="maritalstatusid")  
    private int maritalstatusid;
    @Column(name="nss")  
    private String nss;
    @Column(name="phoneno")  
    private String phoneno;
    @Column(name="emailaddress")  
    private String emailaddress;
    @Column(name="mobileno")  
    private String mobileno;
    @Id
    private Long id;


    public Long getIdclientesibadac() {
        return idclientesibadac;
    }

    public void setIdclientesibadac(Long idclientesibadac) {
        this.idclientesibadac = idclientesibadac;
    }

    public int getRelationshipid() {
        return relationshipid;
    }

    public void setRelationshipid(int relationshipid) {
        this.relationshipid = relationshipid;
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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getGenderid() {
        return genderid;
    }

    public void setGenderid(int genderid) {
        this.genderid = genderid;
    }

    public int getMaritalstatusid() {
        return maritalstatusid;
    }

    public void setMaritalstatusid(int maritalstatusid) {
        this.maritalstatusid = maritalstatusid;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
