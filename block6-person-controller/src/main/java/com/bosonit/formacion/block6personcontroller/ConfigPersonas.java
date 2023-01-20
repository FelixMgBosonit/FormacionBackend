package com.bosonit.formacion.block6personcontroller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPersonas {
    @Bean
    public Persona persona1() {
        return new Persona("bean1", "A Coruña", 20);
    }

    @Bean
    public Persona persona2() {
        return new Persona("bean2", "Madrid", 30);
    }

    @Bean
    public Persona persona3() {
        return new Persona("bean3", "Barcelona", 40);
    }
}