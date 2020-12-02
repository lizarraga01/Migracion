package com.sye.mifosbatch.services;

import com.sye.mifosbatch.config.FeignClientConfiguration;
import com.sye.mifosbatch.model.Client;
import com.sye.mifosbatch.model.ResponseCliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import feign.Headers;

@FeignClient(name = "${service.name}", url = "${service.base.url}", configuration = FeignClientConfiguration.class)
public interface ClientesRESTService {

    @Headers("Fineract-Platform-TenantId:default")
    @PostMapping("/cliente")
    ResponseCliente addUser(Client client);

}

