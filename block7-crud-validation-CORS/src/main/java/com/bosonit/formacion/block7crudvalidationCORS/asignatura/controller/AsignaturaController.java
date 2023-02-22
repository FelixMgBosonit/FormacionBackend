package com.bosonit.formacion.block7crudvalidationCORS.asignatura.controller;

import com.bosonit.formacion.block7crudvalidationCORS.asignatura.application.AsignaturaService;
import com.bosonit.formacion.block7crudvalidationCORS.asignatura.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidationCORS.asignatura.controller.dto.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    AsignaturaService asignaturaService;

    @PostMapping("/")
    public ResponseEntity<AsignaturaOutputDto> addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) {
        return new ResponseEntity<>(asignaturaService.addAsignatura(asignaturaInputDto), HttpStatus.CREATED);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<AsignaturaOutputDto> getAsignaturaById(@PathVariable Integer id) {
            return ResponseEntity.ok().body(asignaturaService.getAsignaturaById(id));
    }


    @GetMapping("/asignaturas")
    public ResponseEntity<List<AsignaturaOutputDto>> getAllAsignaturas() {
        return ResponseEntity.ok().body(asignaturaService.getAllAsignaturas());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<AsignaturaOutputDto> updateAsignatura(@PathVariable("id") Integer id, @RequestBody AsignaturaInputDto asignaturaInputDto) {
            return new ResponseEntity<>(asignaturaService.updateAsignatura(id, asignaturaInputDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAsignaturaById(@PathVariable("id") Integer id) {
            return ResponseEntity.ok().body(asignaturaService.deleteAsignaturaById(id));
    }
}




