package com.sye.mifosbatch.threads;

import com.sye.mifosbatch.commons.PostJSON;
import com.sye.mifosbatch.dao.ClientesDAO;
import com.sye.mifosbatch.dao.LoanDAO;
import com.sye.mifosbatch.dao.PaymentsDAO;
import com.sye.mifosbatch.model.Client;
import com.sye.mifosbatch.model.ResponseCliente;
import com.sye.mifosbatch.services.IMifosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ClientThread extends Thread {

    private IMifosService clienteService;

    private ClientesDAO clientesDAO;

    private String urlclientes;

    private String user;

    private String pwd;

    public ClientThread(IMifosService clienteService, ClientesDAO clientesDAO, String urlclientes, String user, String pwd){
        this.clienteService = clienteService;
        this.clientesDAO = clientesDAO;
        this.urlclientes = urlclientes;
        this.user = user;
        this.pwd = pwd;
    }

    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("ClientThread " +
                    Thread.currentThread().getId() +
                    " is running");

            List<Client> clientes = clienteService.findAllClients();
            int irow=0;
            int isleep= 0;
            for (Client clienteAlta : clientes) {

                PostJSON post= new PostJSON(clientesDAO, clienteAlta, urlclientes, user, pwd, irow);
                post.start();
                if (isleep==30) {
                    try {
                        Thread.sleep(6000);
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
