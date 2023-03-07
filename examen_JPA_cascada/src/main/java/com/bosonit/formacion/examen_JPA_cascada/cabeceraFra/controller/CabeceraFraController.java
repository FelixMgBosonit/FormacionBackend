package com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.application.CabeceraFraService;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraInputDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabeceraFra")
public class CabeceraFraController {

    @Autowired
    CabeceraFraService cabeceraFraService;



    @PostMapping("/")
    public ResponseEntity<CabeceraFraOutputDto> addCabeceraFra (@RequestBody CabeceraFraInputDto cabeceraFraInputDto) {
        return new ResponseEntity<>(cabeceraFraService.addCabeceraFra(cabeceraFraInputDto), HttpStatus.CREATED);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<CabeceraFraOutputDto> getCabeceraFraById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(cabeceraFraService.getCabeceraFraById(id));
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<CabeceraFraOutputDto>> getAllCabeceraFra() {
        return ResponseEntity.ok().body(cabeceraFraService.getAllCabeceraFra());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CabeceraFraOutputDto> updateCabeceraFra(@PathVariable("id") Integer id, @RequestBody CabeceraFraInputDto cabeceraFraInputDto) {
        return new ResponseEntity<>(cabeceraFraService.updateCabeceraFra(id, cabeceraFraInputDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCabeceraFra(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(cabeceraFraService.deleteCabeceraFraById(id));
    }

    @PostMapping("/lineaFra/")
    public ResponseEntity<CabeceraFraOutputDto> addLineaFraToCabeceraFras(@Valid @RequestBody LineaFraInputDto lineaFraInputDto) {
        return ResponseEntity.ok().body(cabeceraFraService.addLineaFraToCabeceraFra(lineaFraInputDto));
    }

}
