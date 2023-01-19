package com.bosonit.formacion.block7crudvalidation.controller;

import com.bosonit.formacion.block7crudvalidation.application.PersonaServiceImpl;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping("/")
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto) {//throws Exception eliminado por los ifs de personaServiceImpl
        try {
            return new ResponseEntity<>(personaService.addPersona(personaInputDto), HttpStatus.CREATED);
        } catch (Exception e) {
            if (personaInputDto.getUsuario() == null) {
                throw new UnprocessableEntityException(" Usuario no puede ser nulo");
            }
            if (personaInputDto.getUsuario().length() < 3){
                throw new UnprocessableEntityException(" Mínimo 3 caracteres.");
            }
            if (personaInputDto.getUsuario().length() > 10){
                throw new UnprocessableEntityException(" Máximo 10 caracteres.");
            }
            if (personaInputDto.getPassword() == null) {
                throw new UnprocessableEntityException(" Password no puede ser nulo");
            }
            if (personaInputDto.getName() == null) {
                throw new UnprocessableEntityException(" Name no puede ser nulo");
            }
            if (personaInputDto.getCompany_email() == null) {
                throw new UnprocessableEntityException(" Company_email no puede ser nulo");
            }
            if (personaInputDto.getPersonal_email() == null) {
                throw new UnprocessableEntityException(" Personal_email no puede ser nulo");
            }
            if (personaInputDto.getCity() == null) {
                throw new UnprocessableEntityException(" City no puede ser nulo");
            }
            if (personaInputDto.getActive() == null) {
                throw new UnprocessableEntityException(" Active no puede ser nulo");
            }
        }

        return null;
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaById(id));
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<PersonaOutputDto> getPersonaByUserName(@PathVariable String usuario) {
        try {
            return ResponseEntity.ok().body(personaService.getPersonaByUserName(usuario));
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }


    @GetMapping("/personas")
    public List<PersonaOutputDto> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable("id") Integer id) {
        try {
            personaService.deletePersonaById(id);
            return ResponseEntity.ok().body(("La persona con id " + id + " ha sido borrad@."));
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaOutputDto> updatePersona(@PathVariable("id") Integer id, @RequestBody PersonaInputDto personaInputDto) {
        try {
            return new ResponseEntity<>(personaService.updatePersona(id, personaInputDto), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }
    }
}




