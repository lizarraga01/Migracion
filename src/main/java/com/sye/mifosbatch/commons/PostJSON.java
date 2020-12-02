package com.sye.mifosbatch.commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sye.mifosbatch.dao.ClientesDAO;
import com.sye.mifosbatch.dao.LoanDAO;
import com.sye.mifosbatch.model.Client;
import com.sye.mifosbatch.model.ResponseCliente;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class PostJSON extends Thread
{
    private ClientesDAO clientesDAO;
    private Client clienteAlta;
    private String urlclientes;
    private String user;
    private String pwd;
    private int registro;

    public PostJSON(ClientesDAO clientesDAO, Client clienteAlta, String urlclientes, String user, String pwd, int registro){
        this.clienteAlta = clienteAlta;
        this.clientesDAO = clientesDAO;
        this.urlclientes = urlclientes;
        this.user = user;
        this.pwd = pwd;
        this.registro = registro;
    }


    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");


            ResponseCliente resp = postJSON(this.clienteAlta);
            if (resp.getClientId()>0)
                clientesDAO.updateClienteSetidmifosForidclientesibadac(resp.getClientId(), resp.getResourceId(), resp.getOfficeId(), "OK", clienteAlta.getIdsibadac());
            else {
                if (!resp.getMessage().startsWith("<html><body><h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, so"))
                    clientesDAO.updateClienteSetidmifosForidclientesibadac(-2, 0, clienteAlta.getOfficeId(), resp.getError(), clienteAlta.getIdsibadac());
            }
            System.out.println("Respuesta: \n Registro: " + registro + " ClientId: " + resp.getClientId() + " -> OfficeId: " + resp.getOfficeId()
                    + " -> ResourceId:" + resp.getResourceId());
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }


    private String  printFechaHora(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public ResponseCliente postJSON(Client cliente) {
        ResponseCliente responseCliente = new ResponseCliente();

        System.out.println("Inicio del proceso: " + printFechaHora());
        try {

            if (urlclientes.contains("localhost:8443")) {
                HttpsURLConnection.setDefaultHostnameVerifier(
                        new HostnameVerifier() {

                            public boolean verify(String hostname,
                                                  javax.net.ssl.SSLSession sslSession) {
                                return hostname.equals("localhost:8443");
                            }
                        });
            } else
                HttpsURLConnection.setDefaultHostnameVerifier(
                        new HostnameVerifier() {

                            public boolean verify(String hostname,
                                                  javax.net.ssl.SSLSession sslSession) {
                                return hostname.equals("localhost:8443");
                            }
                        });
            //Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            final String jsonInputString = gson.toJson(cliente);
            final HttpURLConnection con = (HttpURLConnection) new URL(urlclientes).openConnection();
            final String encoded = Base64.getEncoder().encodeToString((user + ":" + pwd).getBytes(StandardCharsets.UTF_8));
            con.setRequestProperty("Authorization", "Basic " + encoded);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Fineract-Platform-TenantId", "default");
            con.setRequestProperty("Accept-Encoding", "gzip");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            final OutputStream os = con.getOutputStream();
            os.write(jsonInputString.getBytes());
            os.flush();
            os.close();

            System.out.println("Mensaje JSON: " + jsonInputString);
            StringBuilder response = new StringBuilder();
            if (con.getResponseCode() >= 400) {
                String output = "";
                final InputStream inStream = new GZIPInputStream(con.getErrorStream());
                final BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));
                String outputline;
                while ((outputline = responseBuffer.readLine()) != null) {
                    output += outputline;
                }
                responseCliente.setMessage(output);
                System.out.println("ERROR DEL WS: " + output);

            } else {
                String output = "";
                final InputStream inStream = new GZIPInputStream(con.getInputStream());
                final BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));
                String outputline;
                while ((outputline = responseBuffer.readLine()) != null) {
                    output += outputline;
                }
                //System.out.println(output);
                responseCliente = gson.fromJson(output, ResponseCliente.class);
            }

        } catch (IOException ioe) {
            System.out.print("= ERROR en el POST IO= ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.print("= ERROR en el POST = ");
            e.printStackTrace();
        }
        System.out.println("Fin del proceso: " + printFechaHora());
        return responseCliente;

    }





}