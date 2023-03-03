package com.bosonit.formacion.PizzeriaBosonEat.controller;

import com.bosonit.formacion.PizzeriaBosonEat.domain.Pedido;
import com.bosonit.formacion.PizzeriaBosonEat.kafka.ConsumerComentario;
import com.bosonit.formacion.PizzeriaBosonEat.kafka.ProducerEstadoPedido;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("BosonEat/Pizzeria")
public class PizzeriaBosonEatController {

    @Autowired
    private ProducerEstadoPedido producerEstadoPedido;

    @Autowired
    private ConsumerComentario consumerComentario;



    public PizzeriaBosonEatController(ProducerEstadoPedido producerEstadoPedido) {
        this.producerEstadoPedido = producerEstadoPedido;
    }


    @GetMapping("PedidoUpdate")
    public ResponseEntity<String> pedidoUpdate (@RequestBody Pedido pedido) throws JsonProcessingException {
        producerEstadoPedido.sendMessage(pedido);
        return ResponseEntity.ok("Actualización enviada");
    }

    @GetMapping("Comentario")
    public ResponseEntity<String> realiza (){
        return ResponseEntity.ok(consumerComentario.getComentario());
    }

}


