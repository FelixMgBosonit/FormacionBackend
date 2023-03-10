package com.bosonit.formacion.block7crudvalidation.persona.repository;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional <List<Persona>> findByName(String name);

//    public List<Persona> getData(HashMap<String, Object> conditions);
}
