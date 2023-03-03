package com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto;

import com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain.LineaFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LineaFraOuputDto {

    private Integer idLineaFra;

    private String productoNombre;
    private Double cantidad;
    private Double precio;

    public LineaFraOuputDto(LineaFra lineaFra) {
        this.idLineaFra=lineaFra.getIdLineaFra();
        this.productoNombre = lineaFra.getProductoNombre();
        this.cantidad = lineaFra.getCantidad();
        this.precio = lineaFra.getPrecio();

    }

}
