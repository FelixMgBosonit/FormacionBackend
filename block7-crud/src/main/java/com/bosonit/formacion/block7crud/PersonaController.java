package com.bosonit.formacion.block7crud;

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

    @PostMapping
    public void addPersona(@RequestBody Persona persona) {
        personaService.addPersona(persona);
    }


    @PutMapping("{id}")
    public ResponseEntity<String> updateById (@PathVariable("id") Long id, @RequestBody Persona persona){
        Persona pUpdate = personaService.getPersonaById(id);
        if (pUpdate != null) {
            personaService.updatePersona(id, persona);
            return new ResponseEntity<>(pUpdate.getNombre() + " con id " + pUpdate.getId() + " ha sido actualizado.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.toString()+ ": Persona no encontrada.", HttpStatus.NOT_FOUND);
        }

    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> borraPersonaById(@PathVariable("id") Long id) {
        Persona pBorrar = personaService.getPersonaById(id);
        if (pBorrar != null) {
            personaService.deletePersona(id);
            return new ResponseEntity<>(pBorrar.getNombre() + " con id " + pBorrar.getId() + " ha sido borrad@.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.toString()+ ": Persona no encontrada.", HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonasById(@PathVariable("id") Long id) {
        Persona personaEncontradaById = personaService.getPersonaById(id);
        if (personaEncontradaById != null) {
            return new ResponseEntity<>(personaEncontradaById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/nombre/{nombre}")
    public List<Persona> getPersonasByName(@PathVariable("nombre") String nombre) {
        return personaService.getPersonasByName(nombre);
    }


    @GetMapping
    public List<Persona> listaPersonas() {
        return personaService.getAllPersonas();
    }


}
