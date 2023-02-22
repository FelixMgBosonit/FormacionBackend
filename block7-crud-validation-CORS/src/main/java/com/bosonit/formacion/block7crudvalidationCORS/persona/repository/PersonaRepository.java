package com.bosonit.formacion.block7crudvalidationCORS.persona.repository;

import com.bosonit.formacion.block7crudvalidationCORS.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional <List<Persona>> findByName(String name);
}
