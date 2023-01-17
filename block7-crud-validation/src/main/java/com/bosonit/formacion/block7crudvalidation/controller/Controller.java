package com.bosonit.formacion.block7crudvalidation.controller;

import com.bosonit.formacion.block7crudvalidation.application.PersonaServiceImpl;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class Controller {

    @Autowired
    PersonaServiceImpl personaService;


    @PostMapping("/")
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto persona) {

            return new ResponseEntity<>(personaService.addPersona(persona), HttpStatus.CREATED);
        }


    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) {
        return ResponseEntity.ok().body(personaService.getPersonaById(id));
    }


    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<PersonaOutputDto> getPersonaByUserName(@PathVariable String usuario) {
        return ResponseEntity.ok().body(personaService.getPersonaByUserName(usuario));
    }


    @GetMapping("/personas")
    public List<PersonaOutputDto> getAllPersonas() {
        return personaService.getAllPersonas();
    }
}