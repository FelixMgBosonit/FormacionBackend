package com.bosonit.formacion.block7crudvalidation.persona.application;

import com.bosonit.formacion.block7crudvalidation.persona.controller.dto.personaInputDto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.controller.dto.personaOutputDto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface PersonaService {

    PersonaOutputDto addPersona(PersonaInputDto persona);
    PersonaOutputDto getPersonaById(Integer id);
    List<PersonaOutputDto> getPersonasByName(String name);
    List<PersonaOutputDto> getAllPersonas();
    PersonaOutputDto updatePersona(Integer id, PersonaInputDto personaInputDto);
    String deletePersonaById(Integer id);
    List<PersonaOutputDto> getPersonas(String usuario, String name, String surname, Date createdDate, String dateCondition, String orderBy, Integer page, Integer size);


}
