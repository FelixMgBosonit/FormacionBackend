package com.bosonit.formacion.block7crudvalidation.controller.dto;

import com.bosonit.formacion.block7crudvalidation.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDto {
    //En este caso el outDto va a ser = que el inDto salvo la ausencia del Password
    private Integer id_persona;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;



}
