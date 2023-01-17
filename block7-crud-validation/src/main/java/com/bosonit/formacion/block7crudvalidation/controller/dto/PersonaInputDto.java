package com.bosonit.formacion.block7crudvalidation.controller.dto;

import com.bosonit.formacion.block7crudvalidation.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonaInputDto {
    //se autogenera
    //private  int id_persona;
    private String usuario;
    private String password;
    private  String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    //private Date created_date;
    private String imagen_url;
    private Date termination_date;

}