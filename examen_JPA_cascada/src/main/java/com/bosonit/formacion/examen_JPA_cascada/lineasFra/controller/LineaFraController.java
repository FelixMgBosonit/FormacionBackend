package com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller;


import com.bosonit.formacion.examen_JPA_cascada.lineasFra.application.LineaFraService;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraOuputDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lineaFra")
public class LineaFraController {


    @Autowired
    LineaFraService lineaFraService;



    @PostMapping("/")
    public ResponseEntity<LineaFraOuputDto> addLineaFra (@Valid @RequestBody LineaFraInputDto lineaFraInputDto) {
        return new ResponseEntity<>(lineaFraService.addLineaFra(lineaFraInputDto), HttpStatus.CREATED);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<LineaFraOuputDto> getLineaFraById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(lineaFraService.getLineaFraById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<LineaFraOuputDto>> getAllLineaFra() {
        return ResponseEntity.ok().body(lineaFraService.getAllLineaFra());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<LineaFraOuputDto> updateLineaFra(@PathVariable("id") Integer id, @RequestBody LineaFraInputDto lineaFraInputDto) {
        return new ResponseEntity<>(lineaFraService.updateLineaFra(id, lineaFraInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLineaFra(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(lineaFraService.deleteLineaFraById(id));
    }


}


