package com.bosonit.formacion.block7crudvalidationCORS.student.repository;


import com.bosonit.formacion.block7crudvalidationCORS.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidationCORS.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByPersona(Persona persona);
}
