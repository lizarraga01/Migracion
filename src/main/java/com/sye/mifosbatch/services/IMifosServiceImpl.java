package com.sye.mifosbatch.services;

import java.util.ArrayList;
import java.util.List;

import com.sye.mifosbatch.dao.*;
import com.sye.mifosbatch.entity.*;
import com.sye.mifosbatch.model.*;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMifosServiceImpl implements IMifosService {

    @Autowired
    private ClientesDAO clientesDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private LoanDAO loanDAO;

    @Autowired
    private PaymentsDAO paymentsDAO;

    @Autowired
    private FamilyMembresDAO familyMembersDAO;

    @Transactional(readOnly = true)
    public List<Client> findAllClients() {

        List<Cliente> clientesSIBA = (List<Cliente>) clientesDAO.findFirst1000ByIdmifos(0);
        List<Client> clientRet = new ArrayList();
        for (Cliente clienteSiba: clientesSIBA) {
            Client cliente = new Client(clienteSiba);
            List<Address> addr = new ArrayList();
            List<Direccion> direcciones = addressDAO.findByIdclientesibadac(clienteSiba.getIdclientesibadac());
            for (Direccion direc : direcciones) {
                addr.add(new Address(direc));
            }
            List<FamilyMember> fams = new ArrayList();
            List<Familiares> familia = familyMembersDAO.findByIdclientesibadac(clienteSiba.getIdclientesibadac());
            for (Familiares family : familia) {
                fams.add(new FamilyMember(family));
            }
            cliente.setAddress(addr);
            cliente.setFamilyMembers(fams);
            clientRet.add(cliente);
        }

        return clientRet;
    }

    public Client findById(Long id) {
        return null;
        //return clientesDAO.findById(id).orElse(null);
    }

    public List<AltaCredito> findAllLoans() {
        List<Loan> contratosSIBA = (List<Loan>) loanDAO.findFirst1000ByIdmifos(0);
        List<AltaCredito> altaCreditos = new ArrayList();
        for (Loan contratoBD: contratosSIBA) {
            AltaCredito cliente = new AltaCredito(contratoBD);
            altaCreditos.add(cliente);
        }

        return altaCreditos;
    }

    public List<PagoRequest> findAllPayments() {
        List<Payment> pagosSIBA = (List<Payment>) paymentsDAO.findAll();
        List<PagoRequest> altaPagos = new ArrayList();
        for (Payment pagoBD: pagosSIBA) {
            PagoRequest pagoreq = new PagoRequest(pagoBD);
            altaPagos.add(pagoreq);
        }

        return altaPagos;
    }

}
