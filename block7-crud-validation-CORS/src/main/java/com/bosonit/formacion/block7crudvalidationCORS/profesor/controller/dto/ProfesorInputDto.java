package com.bosonit.formacion.block7crudvalidationCORS.profesor.controller.dto;

import lombok.*;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDto {

    private Integer idPersona;
    private String comments;
    private String branch;

}