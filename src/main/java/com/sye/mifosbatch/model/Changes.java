package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Changes {

    @Expose
    private String transactionDate;
    @Expose
    private String transactionAmount;
    @Expose
    private String locale;
    @Expose
    private String dateFormat;
    @Expose
    private String paymentTypeId;
    @Expose
    private String note;

}
