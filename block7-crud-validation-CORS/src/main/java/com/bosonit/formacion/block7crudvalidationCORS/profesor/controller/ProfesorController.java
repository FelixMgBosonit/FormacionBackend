package com.bosonit.formacion.block7crudvalidationCORS.profesor.controller;


import com.bosonit.formacion.block7crudvalidationCORS.profesor.application.ProfesorService;
import com.bosonit.formacion.block7crudvalidationCORS.profesor.controller.dto.ProfesorInputDto;
import com.bosonit.formacion.block7crudvalidationCORS.profesor.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidationCORS.student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesorInputDto) {
        return new ResponseEntity<>(profesorService.addProfesor(profesorInputDto), HttpStatus.CREATED);
    }


    @PostMapping("/student")
    public ResponseEntity<String> addStudentToProfesor (@RequestParam("idProfesor")Integer idProfesor,
                                                        @RequestParam("idStudent")Integer idStudent) {
        return ResponseEntity.ok().body(profesorService.addStudentToProfesor( idProfesor,idStudent));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesorById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(profesorService.getProfesorById(id));
    }



    @GetMapping("/profesores")
    public ResponseEntity<List<ProfesorOutputDto>> getAllProfesores() {
        return ResponseEntity.ok().body(profesorService.getAllProfesores());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ProfesorOutputDto> updateProfesor(@PathVariable("id") Integer id, @RequestBody ProfesorInputDto profesorInputDto) {
        return new ResponseEntity<>(profesorService.updateProfesor(id, profesorInputDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfesorById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body((profesorService.deleteProfesorById(id)));
    }
}



