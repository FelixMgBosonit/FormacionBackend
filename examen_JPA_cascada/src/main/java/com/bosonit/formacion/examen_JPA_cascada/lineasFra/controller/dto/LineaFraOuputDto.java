package com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto;

import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
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
    private Integer idCabeceraFra;
    private ClienteOutputDto clienteOutputDto;

    public LineaFraOuputDto(LineaFra lineaFra) {
        this.idLineaFra=lineaFra.getIdLineaFra();
        this.productoNombre = lineaFra.getProductoNombre();
        this.cantidad = lineaFra.getCantidad();
        this.precio = lineaFra.getPrecio();
        this.idCabeceraFra=lineaFra.getCabeceraFra().getIdCabeceraFra();
        this.clienteOutputDto=new ClienteOutputDto(lineaFra.getCabeceraFra().getCliente());

    }

}
