package com.bosonit.formacion.block10dockerizeapp.controller;

import com.bosonit.formacion.block10dockerizeapp.application.PersonaService;
import com.bosonit.formacion.block10dockerizeapp.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block10dockerizeapp.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping("/")
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto) {
        return new ResponseEntity<>(personaService.addPersona(personaInputDto), HttpStatus.CREATED);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok().body(personaService.getPersonaById(id));
    }


    @GetMapping("/personas")
    public ResponseEntity<List<PersonaOutputDto>> getAllPersonas() {
        return ResponseEntity.ok().body(personaService.getAllPersonas());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable("id") Integer id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        return new ResponseEntity<>(personaService.updatePersona(id, personaInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok().body((personaService.deletePersonaById(id)));
    }
}


