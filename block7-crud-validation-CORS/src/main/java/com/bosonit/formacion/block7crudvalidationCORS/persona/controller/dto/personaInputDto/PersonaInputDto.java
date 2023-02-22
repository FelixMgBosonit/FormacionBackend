package com.bosonit.formacion.block7crudvalidationCORS.persona.controller.dto.personaInputDto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDto {
    private String idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    //private Date createdDate;
    private String imagenUrl;
    private Date terminationDate;

}