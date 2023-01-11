package com.bosonit.formacion.block6personcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {

    @Autowired
    private ServicioPersona servicioPersona;

    @Autowired
    private List<Ciudad> listaCiudades;

    @GetMapping("/getPersona")
    public Persona getPersona() {
        Persona persona = servicioPersona.getPersona();
        persona.setEdad(persona.getEdad() * 2);
        return persona;
    }

    @GetMapping("/getCiudad")
    public List<Ciudad> getCiudad() {
        return listaCiudades;
    }
}