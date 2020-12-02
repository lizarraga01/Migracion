package com.sye.mifosbatch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pagos")
@Data
public class Payment implements Serializable {

    private Long idcreditomifos;
    private int paymenttypeid;
    private Double transactionamount;
    private String transactiondate;
    private String note;
    @Id
    private Long id;

    private Long idcreditosibadac;
    private Long officeid;
    private Long clientid;
    private Long resourceid;
    private String migrationdesc;

    private int migrado;
    private Date lastupdate;

    public Long getIdcreditomifos() {
        return idcreditomifos;
    }

    public void setIdcreditomifos(Long idcreditomifos) {
        this.idcreditomifos = idcreditomifos;
    }

    public int getPaymenttypeid() {
        return paymenttypeid;
    }

    public void setPaymenttypeid(int paymenttypeid) {
        this.paymenttypeid = paymenttypeid;
    }

    public Double getTransactionamount() {
        return transactionamount;
    }

    public void setTransactionamount(Double transactionamount) {
        this.transactionamount = transactionamount;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcreditosibadac() {
        return idcreditosibadac;
    }

    public void setIdcreditosibadac(Long idcreditosibadac) {
        this.idcreditosibadac = idcreditosibadac;
    }

    public Long getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Long officeid) {
        this.officeid = officeid;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public String getMigrationdesc() {
        return migrationdesc;
    }

    public void setMigrationdesc(String migrationdesc) {
        this.migrationdesc = migrationdesc;
    }

    public int getMigrado() {
        return migrado;
    }

    public void setMigrado(int migrado) {
        this.migrado = migrado;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }
}
