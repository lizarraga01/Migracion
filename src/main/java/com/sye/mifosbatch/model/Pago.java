package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Pago {

    @Expose
    private Integer paymentTypeId;
    @Expose
    private Double transactionAmount;
    @Expose
    private String transactionDate;

}