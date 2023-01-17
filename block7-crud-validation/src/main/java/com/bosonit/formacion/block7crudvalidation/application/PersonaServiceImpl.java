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
    public PersonaOutputDto addPersona(PersonaInputDto pInputDto) {
        //-------------------------------------------Parte 1----------------------------------
        //Para añadir una persona hay que pasarle a personaRepository una persona con todos sus campos.
        //Al recogerse un inputDto desde el postman primero hay que crear una persona con esos datos.ç
        //Se construye con constructor vacío, para que el id y la createDate se introduzcan automaticamente.
        Persona p = new Persona();
        //Y ahora se setean todos los demás campos contenidos en el inputDto


        p.setUsuario(pInputDto.getUsuario());
        p.setPassword(pInputDto.getPassword());
        p.setName(pInputDto.getName());
        p.setSurname(pInputDto.getSurname());
        p.setCompany_email(pInputDto.getCompany_email());
        p.setPersonal_email(pInputDto.getPersonal_email());
        p.setCity(pInputDto.getCity());
        p.setActive(pInputDto.getActive());
        p.setImagen_url(pInputDto.getImagen_url());
        p.setTermination_date(pInputDto.getTermination_date());
        //----------------------------------------------------------------------------------


        //-------------------------------------------Parte 2--------------------------------
        //Ahora que tenemos la persona (p) construida se hace un save en el Repositorio.;

        personaRepository.save(p);

        //----------------------------------------------------------------------------------

        //-------------------------------------------Parte 3--------------------------------
        //Ahora se crea un outPutDto de esa persona para devolverlo

        PersonaOutputDto pOutputDto = new PersonaOutputDto();
        pOutputDto.setId_persona(p.getId_persona());
        pOutputDto.setUsuario(p.getUsuario());
        pOutputDto.setName(p.getName());
        pOutputDto.setSurname(p.getSurname());
        pOutputDto.setCompany_email(p.getCompany_email());
        pOutputDto.setPersonal_email(p.getPersonal_email());
        pOutputDto.setCity(p.getCity());
        pOutputDto.setActive(p.getActive());
        pOutputDto.setCreated_date(p.getCreated_date());
        pOutputDto.setImagen_url(p.getImagen_url());
        pOutputDto.setTermination_date(p.getTermination_date());
        //----------------------------------------------------------------------------------

        return pOutputDto;
    }

    @Override
    public PersonaOutputDto getPersonaById(Integer id) {
        Persona p= personaRepository.findById(id).orElseThrow();

        PersonaOutputDto pOutputDto = new PersonaOutputDto();
        pOutputDto.setId_persona(p.getId_persona());
        pOutputDto.setUsuario(p.getUsuario());
        pOutputDto.setName(p.getName());
        pOutputDto.setSurname(p.getSurname());
        pOutputDto.setCompany_email(p.getCompany_email());
        pOutputDto.setPersonal_email(p.getPersonal_email());
        pOutputDto.setCity(p.getCity());
        pOutputDto.setActive(p.getActive());
        pOutputDto.setCreated_date(p.getCreated_date());
        pOutputDto.setImagen_url(p.getImagen_url());
        pOutputDto.setTermination_date(p.getTermination_date());

        return pOutputDto;
    }

    @Override
    public PersonaOutputDto getPersonaByUserName(String usuario) {
        Persona p = personaRepository.findByUsuario(usuario);
        PersonaOutputDto pOutputDto = new PersonaOutputDto();
        pOutputDto.setId_persona(p.getId_persona());
        pOutputDto.setUsuario(p.getUsuario());
        pOutputDto.setName(p.getName());
        pOutputDto.setSurname(p.getSurname());
        pOutputDto.setCompany_email(p.getCompany_email());
        pOutputDto.setPersonal_email(p.getPersonal_email());
        pOutputDto.setCity(p.getCity());
        pOutputDto.setActive(p.getActive());
        pOutputDto.setCreated_date(p.getCreated_date());
        pOutputDto.setImagen_url(p.getImagen_url());
        pOutputDto.setTermination_date(p.getTermination_date());

        return pOutputDto;
    }


    @Override
    public List<PersonaOutputDto> getAllPersonas() {
        List<PersonaOutputDto> pOutputDtoList = new ArrayList<>();
        for (Persona p : personaRepository.findAll()) {
            PersonaOutputDto pOutputDto = new PersonaOutputDto();

            pOutputDto.setId_persona(p.getId_persona());
            pOutputDto.setUsuario(p.getUsuario());
            pOutputDto.setName(p.getName());
            pOutputDto.setSurname(p.getSurname());
            pOutputDto.setCompany_email(p.getCompany_email());
            pOutputDto.setPersonal_email(p.getPersonal_email());
            pOutputDto.setCity(p.getCity());
            pOutputDto.setActive(p.getActive());
            pOutputDto.setCreated_date(p.getCreated_date());
            pOutputDto.setImagen_url(p.getImagen_url());
            pOutputDto.setTermination_date(p.getTermination_date());
            pOutputDtoList.add(pOutputDto);
        }
        return pOutputDtoList;

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








