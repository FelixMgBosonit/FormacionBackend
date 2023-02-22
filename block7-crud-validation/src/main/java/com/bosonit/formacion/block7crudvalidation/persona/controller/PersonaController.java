package com.bosonit.formacion.block7crudvalidation.persona.controller;

import com.bosonit.formacion.block7crudvalidation.persona.application.FeignProfesor;
import com.bosonit.formacion.block7crudvalidation.persona.application.PersonaService;
import com.bosonit.formacion.block7crudvalidation.persona.controller.dto.personaInputDto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.controller.dto.personaOutputDto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.persona.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.profesor.controller.dto.ProfesorOutputDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @Autowired
    FeignProfesor feignProfesor;

    @PostMapping("/")
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto) {//throws Exception eliminado por los ifs de personaServiceImpl
        return new ResponseEntity<>(personaService.addPersona(personaInputDto), HttpStatus.CREATED);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(personaService.getPersonaById(id));
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<PersonaOutputDto>> getPersonasByName(@PathVariable String name) {
        return ResponseEntity.ok().body(personaService.getPersonasByName(name));
    }


    @GetMapping("/personas")
    public ResponseEntity<List<PersonaOutputDto>> getAllPersonas() {
        return ResponseEntity.ok().body(personaService.getAllPersonas());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable("id") Integer id, @RequestBody PersonaInputDto personaInputDto) {
        return new ResponseEntity<>(personaService.updatePersona(id, personaInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body((personaService.deletePersonaById(id)));
    }



    //----------------------------------------FEIGN-------------------------------------------------
    @GetMapping("/profesor/feign/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesorFeign(@PathVariable Integer id) {
        ResponseEntity<ProfesorOutputDto> responseEntity;
        try {
            responseEntity = new ResponseEntity(feignProfesor.getProfesorById(id), HttpStatus.OK);
        } catch (FeignException.NotFound e) {
            throw new EntityNotFoundException("Profesor (Feign) no encontrado");
        }
        return ResponseEntity.ok().body(feignProfesor.getProfesorById(id));
    }


    @GetMapping("/profesor/restTemplate/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesorRestTemplate(@PathVariable Integer id) {
        ResponseEntity<ProfesorOutputDto> responseEntity;
        try {
            responseEntity = new RestTemplate().getForEntity("http://localhost:8080/profesor/id/{id}", ProfesorOutputDto.class, id);
        } catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException("Profesor (RestTemplate) no encontrado");
        }

        return responseEntity;
    }
    //---------------------------------------------------------------------------------------------

}
