package com.bosonit.formacion.block7crudvalidation.asignatura.application;


import com.bosonit.formacion.block7crudvalidation.asignatura.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import com.bosonit.formacion.block7crudvalidation.asignatura.repository.AsignaturaRepository;
import com.bosonit.formacion.block7crudvalidation.persona.exception.EntityNotFoundException;

import com.bosonit.formacion.block7crudvalidation.persona.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    StudentRepository studentRepository;


    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        //Creo una asignatura con el constructor vacío
        Asignatura asignatura = new Asignatura();
        //Seteo los campos con los datos del asignaturaInputDto
        asignatura.setNombreAsignatura(asignaturaInputDto.getNombreAsignatura());
        asignatura.setComments(asignaturaInputDto.getComments());
        asignatura.setBranch(asignaturaInputDto.getBranch());

        //Creo una lista de asignaturas con todas las que ya hay en el repository
        //Con el bucle for valido si ya esxisten los campos unique.
        for (Asignatura a : asignaturaRepository.findAll()) {
            if (a.getNombreAsignatura().equals(asignatura.getNombreAsignatura())) {
                throw new UnprocessableEntityException("Asignatura ya registrada con este nombreAsignatura");
            }
        }

        //Ahora que el profesor está "completo" se guarda en repositorio
        asignaturaRepository.save(asignatura);

        return new AsignaturaOutputDto(asignatura);
    }

    @Override
    public AsignaturaOutputDto getAsignaturaById(Integer id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada."));
        return new AsignaturaOutputDto(asignatura);
    }


    @Override
    public List<AsignaturaOutputDto> getAllAsignaturas() {
        List<AsignaturaOutputDto> listAsignaturaOutputDto = new ArrayList<>();
        for (Asignatura a : asignaturaRepository.findAll()) {
            listAsignaturaOutputDto.add(new AsignaturaOutputDto(a));
        }
        return listAsignaturaOutputDto;
    }

    @Override
    public AsignaturaOutputDto updateAsignatura(Integer id, AsignaturaInputDto asignaturaInputDto) {
        //Creo una asignatura que será igual a la que ya hay en el repositorio.
        Asignatura asignaturaUpdate = asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada."));

        if (asignaturaInputDto.getNombreAsignatura() != null)
            asignaturaUpdate.setNombreAsignatura(asignaturaInputDto.getNombreAsignatura());
        if (asignaturaInputDto.getComments() != null)
            asignaturaUpdate.setComments(asignaturaInputDto.getComments());
        if (asignaturaInputDto.getBranch() != null) asignaturaUpdate.setBranch(asignaturaInputDto.getBranch());

        //----------------------------------------------------------------------------

        //Guardo los cambios
        asignaturaRepository.save(asignaturaUpdate);

        return new AsignaturaOutputDto(asignaturaUpdate);

    }

    @Override
    public String deleteAsignaturaById(Integer id) {
        Asignatura asignatura=asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada."));
        asignaturaRepository.delete(asignatura);
            return "La asignatura con id_Asignatura " + id + " ha sido borrada.";
    }
}
