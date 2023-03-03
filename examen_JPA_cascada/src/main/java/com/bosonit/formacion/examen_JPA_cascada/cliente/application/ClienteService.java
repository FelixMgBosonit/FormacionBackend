package com.bosonit.formacion.examen_JPA_cascada.cliente.application;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    ClienteOutputDto addCliente (ClienteInputDto clienteInputDto);
    ClienteOutputDto getClienteById (Integer id);
    List<ClienteOutputDto> getAllCliente ();
    ClienteOutputDto updateCliente (Integer id, ClienteInputDto clienteInputDto);
    String deleteClienteById (Integer id);
}
