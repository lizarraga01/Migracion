package com.sye.mifosbatch.commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sye.mifosbatch.dao.LoanDAO;
import com.sye.mifosbatch.model.AltaCredito;
import com.sye.mifosbatch.model.ResponseCredito;

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

public class PostJSONCredito  extends Thread {
    private LoanDAO loanDAO;
    private AltaCredito creditoAlta;
    private String urlcreditos;
    private String user;
    private String pwd;
    private int registro;

    public PostJSONCredito(LoanDAO loanDAO, AltaCredito creditoAlta, String urlcreditos, String user, String pwd, int registro) {
        this.creditoAlta = creditoAlta;
        this.loanDAO = loanDAO;
        this.urlcreditos = urlcreditos;
        this.user = user;
        this.pwd = pwd;
        this.registro = registro;
    }

    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " +
                    Thread.currentThread().getId() +
                    " is running");

            ResponseCredito resp = postJSON(creditoAlta);
            System.out.println("Credito procesado SIBADAC: " + creditoAlta.getNoCreditoAnterior());
            if (resp.getCommandId() > 0)
                loanDAO.updateCreditoSetidmifosForidcreditosibadac(resp.getCommandId(), "OK", Long.parseLong(creditoAlta.getNoCreditoAnterior()));
            else {
                if (resp.getMessage() != null && !resp.getMessage().startsWith("<html><body><h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, "))
                    loanDAO.updateCreditoSetidmifosForidcreditosibadac(0, resp.getError(), Long.parseLong(creditoAlta.getNoCreditoAnterior()));
            }
            System.out.println("Respuesta: \n Registro: " + registro + " CommandId: " + resp.getCommandId() + " -> Mensaje: " + resp.getMessage());

        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }


    private String printFechaHora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public ResponseCredito postJSON(AltaCredito credito) {
        String msgLog = "Inicio del proceso: " + printFechaHora();
        ResponseCredito responseWS = new ResponseCredito();
        System.out.println("Inicio del proceso: " + printFechaHora());
        try {
            if (urlcreditos.contains("192.168.30.126")) {
                HttpsURLConnection.setDefaultHostnameVerifier(
                        new HostnameVerifier() {

                            public boolean verify(String hostname,
                                                  javax.net.ssl.SSLSession sslSession) {
                                return hostname.equals("192.168.30.126");
                            }
                        });
            } else
                HttpsURLConnection.setDefaultHostnameVerifier(
                        new HostnameVerifier() {

                            public boolean verify(String hostname,
                                                  javax.net.ssl.SSLSession sslSession) {
                                return hostname.equals("192.168.30.3");
                            }
                        });

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            final String jsonInputString = gson.toJson(credito);
            final HttpURLConnection con = (HttpURLConnection) new URL(urlcreditos).openConnection();
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
                responseWS.setMessage(output);
                System.out.println("ERROR DEL WS: " + output);

            } else {
                String output = "";
                final InputStream inStream = new GZIPInputStream(con.getInputStream());
                final BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));
                String outputline;
                while ((outputline = responseBuffer.readLine()) != null) {
                    output += outputline;
                }
                System.out.println(output);
                responseWS.setMessage("OK");
                responseWS = gson.fromJson(output, ResponseCredito.class);
            }

        } catch (IOException ioe) {
            System.out.print("= ERROR en el POST IO= ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.print("= ERROR en el POST = ");
            e.printStackTrace();
        }
        System.out.println("Registro: " + registro  + msgLog + "\n Fin del proceso: " + printFechaHora());
        return responseWS;

    }


}


