package com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LineaFraInputDto {

    private String productoNombre;
    private Double cantidad;
    private Double precio;
    private Integer idCabeceraFra;

}
