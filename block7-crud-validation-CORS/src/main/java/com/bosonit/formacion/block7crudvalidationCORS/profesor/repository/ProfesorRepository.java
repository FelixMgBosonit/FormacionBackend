package com.bosonit.formacion.block7crudvalidationCORS.profesor.repository;

import com.bosonit.formacion.block7crudvalidationCORS.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidationCORS.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    Profesor findByPersona(Persona persona);
}
