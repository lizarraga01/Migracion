package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ResponsePago {

    @Expose
    private Long officeId;
    @Expose
    private Long clientId;
    @Expose
    private Long loanId;
    @Expose
    private Long resourceId;
    @Expose
    private Changes changes;

    private String message;

    public String getError(){
        if (this.message == null )
            return "";
        else if( this.message.length()>255)
            return this.message.substring(0,254);
        else
            return this.message;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Changes getChanges() {
        return changes;
    }

    public void setChanges(Changes changes) {
        this.changes = changes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
