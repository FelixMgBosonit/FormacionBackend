package com.bosonit.formacion.block7crudvalidationCORS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Block7CrudValidationApplicationCORS {

    public static void main(String[] args) {
        SpringApplication.run(Block7CrudValidationApplicationCORS.class, args);
    }

}
