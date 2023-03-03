package com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraOuputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain.LineaFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CabeceraFraOutputDto {

    private Integer idCabeceraFra;
    private Integer idCliente;
    private String nombreCliente;
    private Double importeFra;
    private ClienteOutputDto clienteOutputDto;
    private List<LineaFraOuputDto> lineaFraOuputDtoList = new ArrayList<>();


    public CabeceraFraOutputDto(CabeceraFra cabeceraFra) {

        this.idCabeceraFra = cabeceraFra.getIdCabeceraFra();
        this.idCliente = cabeceraFra.getCliente().getIdCliente();
        this.nombreCliente = cabeceraFra.getCliente().getNombreCliente();
        this.importeFra = cabeceraFra.getImporteFra();
        this.clienteOutputDto = new ClienteOutputDto(cabeceraFra.getCliente());
        this.lineaFraOuputDtoList = cabeceraFra.getLineaFraList().stream().map(LineaFraOuputDto::new).toList();
    }
}
