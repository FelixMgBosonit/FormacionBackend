package com.bosonit.formacion.block10dockerizeapp.controller.dto;

import com.bosonit.formacion.block10dockerizeapp.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDto {
    Integer id;
    String name;
    Integer age;
    String city;

    public PersonaOutputDto(Persona persona) {
        this.id = persona.getId();
        this.name = persona.getName();
        this.age = persona.getAge();
        this.city = persona.getCity();
    }
}

