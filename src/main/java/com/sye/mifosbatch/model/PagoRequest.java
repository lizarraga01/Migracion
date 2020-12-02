package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import com.sye.mifosbatch.entity.Payment;
import lombok.Data;

@Data
public class PagoRequest {

    public PagoRequest(Payment pago) {

        this.setIdCredito(pago.getIdcreditomifos());
        this.setDateFormat("dd/MM/yyyy");
        this.setId(pago.getId());
        this.setLocale("es_MX");
        this.setNote(pago.getNote());
        this.setPaymentTypeId(pago.getPaymenttypeid());
        this.setTransactionAmount(pago.getTransactionamount());
        this.setTransactionDate(pago.getTransactiondate());
    }

    @Expose
    private int paymentTypeId;
    @Expose
    private double transactionAmount;
    @Expose
    private String transactionDate;
    @Expose
    private String note;
    @Expose
    private String locale;
    @Expose
    private String dateFormat;

    private Long id;

    private Long idCredito;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Long idCredito) {
        this.idCredito = idCredito;
    }
}
