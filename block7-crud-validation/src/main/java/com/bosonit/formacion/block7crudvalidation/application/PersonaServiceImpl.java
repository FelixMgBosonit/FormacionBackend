package com.bosonit.formacion.block7crudvalidation.application;

import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.repository.PersonaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepositoy personaRepository;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) {
        //Instancio objeto persona con el inPut por parámetro
        Persona p = new Persona(personaInputDto);


        //Guardo la persona p en el repositorio
        personaRepository.save(p);

        //Creo un outPutDto de esa persona para devolverlo
        //PersonaOutputDto personaOutputDto =new PersonaOutputDto(p);

        return new PersonaOutputDto(p);
    }

    @Override
    public PersonaOutputDto getPersonaById(Integer id) {
        return new PersonaOutputDto(personaRepository.findById(id).orElseThrow());
    }

    @Override
    public PersonaOutputDto getPersonaByUserName(String usuario) {
        return new PersonaOutputDto(personaRepository.findByUsuario(usuario));
    }


    @Override
    public List<PersonaOutputDto> getAllPersonas() {
        List<PersonaOutputDto> personaOutputDtoList = new ArrayList<>();

        for (Persona p : personaRepository.findAll()) {
            personaOutputDtoList.add(new PersonaOutputDto(p));
        }
        return personaOutputDtoList;

    }
}

//-------------------------------Opción Sergio 1---------------------------------------
//    @Override
//    public List<PersonaOutputDto> getAllPersonas() {
//        List<PersonaOutputDto> personaOutputDtoList= new ArrayList<>();
//
////        personaRepository.findAll().forEach(persona -> {
////            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
////            personaOutputDtoList.add(personaOutputDto);


//-------------------------------Opción Sergio 2---------------------------------------
//        @Override
//        public List<PersonOutputDTO> getPersons() {
//            List<PersonOutputDTO> tempList = new ArrayList<>();
//            iPersonRepository.findAll().forEach(person -> {
//                PersonOutputDTO personOutputDTO = new PersonOutputDTO(person);
//                tempList.add(personOutputDTO);
//            });
//            return tempList;
//        }
//-------------------------------Opción Sergio 3---------------------------------------
//    List<Persona> personas = personaRepository.findAll();
//        return personas.stream().map(PersonaOutputDto::new).toList();
//-------------------------------------------------------------------------------------








