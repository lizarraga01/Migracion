package com.sye.mifosbatch.threads;

import com.sye.mifosbatch.commons.PostJSON;
import com.sye.mifosbatch.commons.PostJSONCredito;
import com.sye.mifosbatch.dao.ClientesDAO;
import com.sye.mifosbatch.dao.LoanDAO;
import com.sye.mifosbatch.model.AltaCredito;
import com.sye.mifosbatch.model.Client;
import com.sye.mifosbatch.model.ResponseCredito;
import com.sye.mifosbatch.services.IMifosService;

import java.util.List;

public class CreditosThread extends Thread {


    private IMifosService clienteService;

    private LoanDAO loanDAO;

    private String urlcreditos;

    private String user;

    private String pwd;

    public CreditosThread(IMifosService clienteService, LoanDAO loanDAO, String urlcreditos, String user, String pwd){
        this.clienteService = clienteService;
        this.loanDAO = loanDAO;
        this.urlcreditos = urlcreditos;
        this.user = user;
        this.pwd = pwd;
    }

    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("CreditosThread " +
                    Thread.currentThread().getId() +
                    " is running");
            int irow=0;
            int isleep= 0;
            List<AltaCredito> creditosBD = clienteService.findAllLoans();
            for (AltaCredito creditoAlta : creditosBD) {

                PostJSONCredito post= new PostJSONCredito(loanDAO, creditoAlta, urlcreditos, user, pwd, irow);
                post.start();
                if (isleep==15) {
                    try {
                        Thread.sleep(120000);
                    } catch (Exception e) {}
                    isleep = 0;
                } else
                    isleep = isleep+1;
                irow= irow+1;
                System.out.println("Registros procesados:"  + irow);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println ("Exception is caught");
        }
    }

}
