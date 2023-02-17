package com.bosonit.formacion.block10dockerizeapp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {
    Integer id;
    String name;
    Integer age;
    String city;
}
