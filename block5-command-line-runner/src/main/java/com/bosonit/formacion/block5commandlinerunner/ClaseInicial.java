package com.bosonit.formacion.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ClaseInicial {

    @PostConstruct
    public void funcionSaluda(){
        System.out.println("Hola desde clase inicial");
    }
}
