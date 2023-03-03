package com.example.KafkaBosonEatConsumer.controller;

import com.example.KafkaBosonEatConsumer.domain.Pedido;
import com.example.KafkaBosonEatConsumer.kafka.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/BosonEat/")
public class MessageController {

    @Autowired
    private KafkaConsumer kafkaConsumer;


    public MessageController(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/history")
    public ResponseEntity<List<Pedido>> getHistory(){
        return ResponseEntity.ok(kafkaConsumer.getAllEstadosPedido());
    }

    @GetMapping("/last")
    public ResponseEntity<Pedido> getLast(){
        return ResponseEntity.ok(kafkaConsumer.getLastEstadoPedido());
    }
}