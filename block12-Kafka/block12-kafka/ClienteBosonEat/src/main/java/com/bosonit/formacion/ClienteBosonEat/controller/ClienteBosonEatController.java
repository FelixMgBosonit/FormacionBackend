package com.bosonit.formacion.ClienteBosonEat.controller;

import com.bosonit.formacion.ClienteBosonEat.domain.Pedido;
import com.bosonit.formacion.ClienteBosonEat.kafka.ConsumerEstadoPedido;
import com.bosonit.formacion.ClienteBosonEat.kafka.ProducerComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BosonEat/Cliente")
public class ClienteBosonEatController {
    @Autowired
    private ProducerComentario producerComentario;
    @Autowired
    private ConsumerEstadoPedido consumerEstadoPedido;



    public ClienteBosonEatController(ConsumerEstadoPedido consumerEstadoPedido) {
        this.consumerEstadoPedido = consumerEstadoPedido;
    }


    @GetMapping("Estado")
    public ResponseEntity<Pedido> getLast(){
        return ResponseEntity.ok(consumerEstadoPedido.getLastEstadoPedido());


    }
    @GetMapping("Historial")
    public ResponseEntity<List<Pedido>> getHistory(){
        return ResponseEntity.ok(consumerEstadoPedido.getAllEstadosPedido());
    }



    @GetMapping("DejaComentario")
    public ResponseEntity<String> dejaComentario (@RequestBody String comentario){
        producerComentario.sendComentario(comentario);
        return ResponseEntity.ok("Gracias por su comentario");
    }
}