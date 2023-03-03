package com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto;


import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteOutputDto {

    private Integer idCliente;
    private String nombreCliente;

    public ClienteOutputDto (Cliente cliente){
        this.idCliente=cliente.getIdCliente();
        this.nombreCliente=cliente.getNombreCliente();
    }

}
