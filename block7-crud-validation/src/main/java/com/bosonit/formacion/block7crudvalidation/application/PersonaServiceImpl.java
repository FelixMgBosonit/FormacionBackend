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
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) {//throws Exception eliminado por los ifs de personaServiceImpl
        //Instancio objeto persona con el inPut por parámetro
        Persona p = new Persona(personaInputDto);

// Parte anterior del ejercicio, al realizar las excepciones propias estos ifs no son necesarios

//        //Realizar validaciones necesarias con lógica en java (no usar etiqueta @Valid)
//        if (p.getUsuario() == null) {
//            throw new Exception("Usuario no puede ser nulo");
//        }
//        if (p.getUsuario() == null || p.getUsuario().length() < 3 || p.getUsuario().length() > 10) {
//            //En el ejercicio ponía mínimo 6, cambio a 3: Jose,Eva..
//            throw new Exception("Usuario debe tener entre 6 y 10 caracteres y no puede ser nulo");
//        }
//        if (p.getPassword() == null) {
//            throw new Exception("Password no puede ser nulo");
//        }
//        if (p.getName() == null) {
//            throw new Exception("Name no puede ser nulo");
//        }
//        if (p.getCompany_email() == null) {
//            throw new Exception("Company_email no puede ser nulo");
//        }
//        if (p.getPersonal_email() == null) {
//            throw new Exception("Personal_email no puede ser nulo");
//        }
//        if (p.getCity() == null) {
//            throw new Exception("City no puede ser nulo");
//        }
//        if (p.getActive() == null) {
//            throw new Exception("Active no puede ser nulo");
//        }

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

    @Override
    public void deletePersonaById(Integer id) {
        personaRepository.deleteById(id);

    }

    @Override
    public PersonaOutputDto updatePersona(Integer id, PersonaInputDto personaInputDto) {
        //Creo una persona que será igual a la que ya hay en el repositorio.
        Persona personaUpdate= personaRepository.findById(id).orElseThrow();

        //Seteo los diferentes campos de esa persona desde el input
        //Los que no se setean siguen igual...con lo que id y fechaCreación seguirían igual
        //Si pasamos un json con menos campos esos campos en el input van a nulo, y salaría la excepcion
        //Con estos if si van a nulos no setean, dejando los valores anteriores que ya están controlados en el add.

        if(personaInputDto.getUsuario()!=null) personaUpdate.setUsuario(personaInputDto.getUsuario());
        if(personaInputDto.getPassword()!=null) personaUpdate.setPassword(personaInputDto.getPassword());
        if(personaInputDto.getName()!=null) personaUpdate.setName(personaInputDto.getName());
        if(personaInputDto.getSurname()!=null) personaUpdate.setSurname(personaInputDto.getSurname());
        if(personaInputDto.getCompany_email()!=null)  personaUpdate.setCompany_email(personaInputDto.getCompany_email());
        if(personaInputDto.getPersonal_email()!=null) personaUpdate.setPersonal_email(personaInputDto.getPersonal_email());
        if(personaInputDto.getCity()!=null) personaUpdate.setCity(personaInputDto.getCity());
        if(personaInputDto.getActive()!=null) personaUpdate.setActive(personaInputDto.getActive());
        if(personaInputDto.getImagen_url()!=null) personaUpdate.setImagen_url(personaInputDto.getImagen_url());
        if(personaInputDto.getTermination_date()!=null) personaUpdate.setTermination_date(personaInputDto.getTermination_date());

        //Guardo los cambios
        personaRepository.save(personaUpdate);


        return  new PersonaOutputDto(personaUpdate);
    }


}







