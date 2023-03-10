package com.bosonit.formacion.block7crudvalidation.persona.controller.dto.personaOutputDto;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.profesor.controller.dto.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaProfesorOutputDto extends PersonaOutputDto {
    private ProfesorOutputDto profesorOutputDto;



    //Constructor con persona por Parámetro.
    public PersonaProfesorOutputDto(Persona persona) {
        super(persona);
        this.profesorOutputDto = new ProfesorOutputDto(persona.getProfesor());
    }
}

