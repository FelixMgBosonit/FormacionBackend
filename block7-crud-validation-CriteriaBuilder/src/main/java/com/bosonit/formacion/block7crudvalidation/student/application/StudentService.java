package com.bosonit.formacion.block7crudvalidation.student.application;

import com.bosonit.formacion.block7crudvalidation.student.controller.dto.studentInputDto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.studentOutputDto.StudentOutputDtoSimple;

import java.util.List;

public interface StudentService {

    StudentOutputDtoSimple addStudent(StudentInputDto StudentInputDto);
    String addStudentToAsignaturas(Integer idStudent, List<Integer> idsAsignaturas);
    String removeAsignaturasFromStudent(Integer idStudent, List<Integer> idsAsignaturas);
    StudentOutputDtoSimple getStudentById(Integer id, String outputType);
    List<StudentOutputDtoSimple> getAllStudents();
    StudentOutputDtoSimple updateStudent (Integer id, StudentInputDto studentInputDto);
    String deleteStudentById (Integer id);


}
