package com.bosonit.formacion.block7crudvalidationCORS.persona.controller.dto.personaOutputDto;

import com.bosonit.formacion.block7crudvalidationCORS.asignatura.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidationCORS.persona.domain.Persona;

import com.bosonit.formacion.block7crudvalidationCORS.profesor.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidationCORS.student.controller.dto.studentOutputDto.StudentOutputDtoSimple;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaStudentOutputDto extends PersonaOutputDto {
    private StudentOutputDtoSimple studentOutputDtoSimple;
    private ProfesorOutputDto profesorOutputDto;
    private List<AsignaturaOutputDto> listAsignaturas = new ArrayList<>();

    public PersonaStudentOutputDto(Persona persona) {
        super(persona);
        this.studentOutputDtoSimple = new StudentOutputDtoSimple(persona.getStudent());
        this.profesorOutputDto = new ProfesorOutputDto(persona.getStudent().getProfesor());
        this.listAsignaturas=persona.getStudent().getAsignaturas().stream().map(AsignaturaOutputDto::new).toList();
    }
}
