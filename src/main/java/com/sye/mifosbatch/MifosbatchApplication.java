package com.sye.mifosbatch;

import com.sye.mifosbatch.controllers.ClientesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MifosbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MifosbatchApplication.class, args);
	}

}
