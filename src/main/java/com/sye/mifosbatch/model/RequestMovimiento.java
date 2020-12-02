package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class RequestMovimiento {

    public RequestMovimiento(){
        this.setDateFormat("dd/MM/yyyy");
        this.setLocale("es_MX");
    }

    @Expose
    private Integer idCredito;
    @Expose
    private String locale;
    @Expose
    private String dateFormat;
    @Expose
    private List<Pago> pagos = null;


}