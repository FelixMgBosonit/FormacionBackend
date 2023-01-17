package com.bosonit.formacion.block7crudvalidation.application;

import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    PersonaOutputDto addPersona(PersonaInputDto persona);
    PersonaOutputDto getPersonaById(Integer id);
    PersonaOutputDto getPersonaByUserName(String user);
    List<PersonaOutputDto> getAllPersonas();

}
