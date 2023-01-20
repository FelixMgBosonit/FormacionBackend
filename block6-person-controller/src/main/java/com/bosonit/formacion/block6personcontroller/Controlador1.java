package com.bosonit.formacion.block6personcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {

    @Autowired
    ServicioPersona servicioPersona;
    @Autowired
    List<Ciudad> listaCiudades;


    @GetMapping("/addPersona")
    public Persona addPersona(@RequestHeader("nombre") String nombre,
                              @RequestHeader("poblacion") String poblacion,
                              @RequestHeader("edad") int edad) {

        return servicioPersona.creaPersona(nombre,poblacion,edad);
    }

    @PostMapping("/addCiudad")
    public List<Ciudad> addCiudad(@RequestBody Ciudad ciudad) {
        listaCiudades.add(ciudad);
        return listaCiudades;
    }



}