package com.bosonit.formacion.examen_JPA_cascada.cliente.controller;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.application.ClienteService;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cliente.controller.dto.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;



    @PostMapping("/")
    public ResponseEntity<ClienteOutputDto> addCliente (@RequestBody ClienteInputDto clienteInputDto) {
        return new ResponseEntity<>(clienteService.addCliente(clienteInputDto), HttpStatus.CREATED);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<ClienteOutputDto> getClienteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ClienteOutputDto>> getAllCliente() {
        return ResponseEntity.ok().body(clienteService.getAllCliente());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteOutputDto> updateCliente(@PathVariable("id") Integer id, @RequestBody ClienteInputDto clienteInputDto) {
        return new ResponseEntity<>(clienteService.updateCliente(id, clienteInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(clienteService.deleteClienteById(id));
    }


}
