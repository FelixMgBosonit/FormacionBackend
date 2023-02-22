package com.bosonit.formacion.block7crudvalidationCORS.profesor.application;

import com.bosonit.formacion.block7crudvalidationCORS.profesor.controller.dto.ProfesorInputDto;
import com.bosonit.formacion.block7crudvalidationCORS.profesor.controller.dto.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {

    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto);

    String addStudentToProfesor(Integer idProfesor, Integer idStudent);

    ProfesorOutputDto getProfesorById(Integer id);

    List<ProfesorOutputDto> getAllProfesores();

    ProfesorOutputDto updateProfesor(Integer id, ProfesorInputDto profesorInputDto);

    String deleteProfesorById(Integer id);


}
