package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ResponseCredito {

    @Expose
    private int commandId;
    private String message;

    public String getError(){
        if (this.message == null )
            return "";
        else if( this.message.length()>255)
            return this.message.substring(0,254);
        else
            return this.message;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
