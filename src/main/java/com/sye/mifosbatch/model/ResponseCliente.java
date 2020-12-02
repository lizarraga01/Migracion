package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ResponseCliente {
    @Expose
    private int officeId;
    @Expose
    private int clientId;
    @Expose
    private int resourceId;
    @Expose
    private String message;

    public String getError(){
        if (this.message == null )
            return "";
        else if( this.message.length()>255)
            return this.message.substring(0,254);
        else
            return this.message;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
