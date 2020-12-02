package com.sye.mifosbatch.services;

import java.util.List;

import com.sye.mifosbatch.model.AltaCredito;
import com.sye.mifosbatch.model.Client;
import com.sye.mifosbatch.model.PagoRequest;

public interface IMifosService {
    public List<Client> findAllClients();
    public Client findById(Long id);

    public List<AltaCredito> findAllLoans();

    public List<PagoRequest> findAllPayments();

}
