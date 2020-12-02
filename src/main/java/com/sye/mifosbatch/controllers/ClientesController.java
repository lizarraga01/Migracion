package com.sye.mifosbatch.controllers;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sye.mifosbatch.commons.PostJSON;
import com.sye.mifosbatch.dao.ClientesDAO;
import com.sye.mifosbatch.dao.LoanDAO;
import com.sye.mifosbatch.dao.PaymentsDAO;
import com.sye.mifosbatch.model.*;
import com.sye.mifosbatch.services.IMifosService;
import com.sye.mifosbatch.threads.ClientThread;
import com.sye.mifosbatch.threads.CreditosThread;
import com.sye.mifosbatch.threads.PagosThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ClientesController {

    @Autowired
    private IMifosService clienteService;

    @Autowired
    private ClientesDAO clientesDAO;

    @Autowired
    private LoanDAO loanDAO;

    @Autowired
    private PaymentsDAO paymentsDAO;

    @Value("${service.clientes.url}")
    private String urlclientes;

    @Value("${service.creditos.url}")
    private String urlcreditos;

    @Value("${service.pagos.url}")
    private String urlpagos;

    @Value("${service.user}")
    private String user;

    @Value("${service.password}")
    private String pwd;

    @GetMapping("/altaclientes")
    public List<Client> listar() {

        ClientThread clientThread = new ClientThread(clienteService, clientesDAO, urlclientes, user, pwd);
        clientThread.start();
        /*
        List<Client> clientes = clienteService.findAllClients();
        int irow=0;
        int isleep= 0;
        for (Client clienteAlta : clientes) {

            PostJSON post= new PostJSON(clientesDAO, clienteAlta, urlclientes, user, pwd);
            post.start();
            if (isleep==10) {
                try {
                    Thread.sleep(30000);
                } catch (Exception e) {}
                isleep = 0;
            } else
                isleep = isleep+1;
            irow= irow+1;
            System.out.println("Registros procesados:"  + irow);
        }
        return clientes;
        */

        return new ArrayList<Client>();
    }

    @GetMapping("/altacreditos")
    public List<AltaCredito> altacredito() {

        CreditosThread creditosThread = new CreditosThread(clienteService, loanDAO, urlcreditos, user, pwd);
        creditosThread.start();
        /*
        List<AltaCredito> creditosBD = clienteService.findAllLoans();
        for (AltaCredito creditoAlta : creditosBD) {
            ResponseCredito resp = postJSON(creditoAlta);
            System.out.println("Credito procesado SIBADAC: " + creditoAlta.getNoCreditoAnterior());
            if (resp.getCommandId() >0)
                loanDAO.updateCreditoSetidmifosForidcreditosibadac(resp.getCommandId(),  "OK", Long.parseLong(creditoAlta.getNoCreditoAnterior()));
            else
                loanDAO.updateCreditoSetidmifosForidcreditosibadac(0, resp.getError(),Long.parseLong(creditoAlta.getNoCreditoAnterior()));
            System.out.println("Respuesta: \n CommandId: " + resp.getCommandId() + " -> Mensaje: " + resp.getMessage());
        }
        return creditosBD;
        */
        return new ArrayList<AltaCredito>();
    }


    @GetMapping("/aplicapagos")
    public List<PagoRequest> aplicapago() {


        PagosThread creditosThread = new PagosThread(clienteService, paymentsDAO, urlpagos, user, pwd);
        creditosThread.start();

        /*
        List<PagoRequest> pagosBD = clienteService.findAllPayments();
        for (PagoRequest pagoreq : pagosBD) {
            ResponsePago resp = postJSON(pagoreq);
            System.out.println("Pago procesado SIBADAC: " + pagoreq.getId());
            if (resp.getLoanId()!= null && resp.getLoanId() >0)
                paymentsDAO.updateEstatusPago(resp.getClientId(), resp.getOfficeId(), resp.getResourceId(), "OK", pagoreq.getId());
            else
                paymentsDAO.updateEstatusPago(Long.parseLong("0"), Long.parseLong("0"),Long.parseLong("0"), resp.getError(),pagoreq.getId());
            System.out.println("Respuesta: \n idCliente: " + resp.getClientId() + " -> Mensaje: " + resp.getMessage());
        }
        //return pagosBD;
        */
        return new ArrayList<PagoRequest>();
    }

    @GetMapping("/ver/{id}")
    public Client detalle(@PathVariable Long id) {
        Client cliente = clienteService.findById(id);
        return cliente;
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

            HttpsURLConnection.setDefaultHostnameVerifier(
                    new HostnameVerifier() {

                        public boolean verify(String hostname,
                                              javax.net.ssl.SSLSession sslSession) {
                            return hostname.equals("192.168.30.126");
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


    public ResponseCredito postJSON(AltaCredito credito) {
        ResponseCredito responseWS = new ResponseCredito();
        System.out.println("Inicio del proceso: " + printFechaHora());
        try {
            if (urlclientes.contains("192.168.30.126")) {
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
        System.out.println("Fin del proceso: " + printFechaHora());
        return responseWS;

    }


    public ResponsePago postJSON(PagoRequest credito) {
        ResponsePago responseWS = new ResponsePago();
        System.out.println("Inicio del proceso: " + printFechaHora());
        try {
            if (urlclientes.contains("192.168.30.126")) {
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
            String urlPago = urlpagos + credito.getIdCredito() + "/transactions?command=repayment";
            final HttpURLConnection con = (HttpURLConnection) new URL(urlPago).openConnection();
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
                responseWS = gson.fromJson(output, ResponsePago.class);
            }

        } catch (IOException ioe) {
            System.out.print("= ERROR en el POST IO= ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.print("= ERROR en el POST = ");
            e.printStackTrace();
        }
        System.out.println("Fin del proceso: " + printFechaHora());
        return responseWS;

    }



}
