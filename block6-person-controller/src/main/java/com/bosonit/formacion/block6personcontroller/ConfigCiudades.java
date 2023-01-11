package com.bosonit.formacion.block6personcontroller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigCiudades {
@Bean
public List<Ciudad> listaCiudades() {
    return new ArrayList<>();
}
}
