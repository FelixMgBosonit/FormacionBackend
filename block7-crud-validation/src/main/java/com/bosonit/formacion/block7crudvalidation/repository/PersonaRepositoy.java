package com.bosonit.formacion.block7crudvalidation.repository;

import com.bosonit.formacion.block7crudvalidation.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositoy extends JpaRepository<Persona,Integer> {
    Persona findByUsuario(String user);
}
