package com.bosonit.formacion.block7crudvalidation.student.controller;

import com.bosonit.formacion.block7crudvalidation.student.application.StudentService;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.studentInputDto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.studentOutputDto.StudentOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<StudentOutputDtoSimple> addStudent(@RequestBody StudentInputDto studentInputDto) {
        return new ResponseEntity<>(studentService.addStudent(studentInputDto), HttpStatus.CREATED);
    }


    @PostMapping("/addStudentToAsignaturas")
    public ResponseEntity<String> addStudentToAsignatura(@RequestParam("idStudent") Integer idStudent,
                                                         @RequestParam("idsAsignaturas") List<Integer> idsAsignaturas) {
        return ResponseEntity.ok().body(studentService.addStudentToAsignaturas(idStudent, idsAsignaturas));
    }


    @PutMapping("/removeAsignaturasFromStudent")
    public ResponseEntity<String> removeAsignaturasFromStudent(@RequestParam("idStudent") Integer idStudent,
                                                               @RequestParam("idsAsignaturas") List<Integer> idsAsignaturas) {
        return ResponseEntity.ok().body(studentService.removeAsignaturasFromStudent(idStudent, idsAsignaturas));
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<StudentOutputDtoSimple> getStudentById(@PathVariable Integer id,
                                                                 @RequestParam(value="outputType",defaultValue = "simple") String outputType) {
        return ResponseEntity.ok().body(studentService.getStudentById(id, outputType));
    }


    @GetMapping("/students")
    public ResponseEntity<List<StudentOutputDtoSimple>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StudentOutputDtoSimple> updateStudent(@PathVariable("id") Integer id, @RequestBody StudentInputDto studentInputDto) {
        return new ResponseEntity<>(studentService.updateStudent(id, studentInputDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(studentService.deleteStudentById(id));
    }
}




