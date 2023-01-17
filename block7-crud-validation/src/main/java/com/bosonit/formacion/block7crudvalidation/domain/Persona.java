package com.bosonit.formacion.block7crudvalidation.domain;

import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table //(name="Person") Por default el nombe de la clase--Así Person
public class Persona {
    @Id
    @GeneratedValue
    private Integer id_persona;

    @Column(nullable = false, length = 10)
    private String usuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private  String name;

    private String surname;

    @Column(nullable = false)
    private String company_email;

    @Column(nullable = false)
    private String personal_email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @CreationTimestamp//Con esta anotación se introduce la fecha de creación de entidad, nunca será nula
    private Date created_date;

    private String imagen_url;

    private Date termination_date;


    //Con este metodo se crea una pesrsona pasando por parámetro un PersonaInputDTO
    public Persona (PersonaInputDto personaInputDto){
       // this.id_persona=personaInputDto.getId_persona();
        this.usuario=personaInputDto.getUsuario();
        this.password=personaInputDto.getPassword();
        this.name=personaInputDto.getName();
        this.surname=personaInputDto.getSurname();
        this.company_email=personaInputDto.getCompany_email();
        this.personal_email=personaInputDto.getPersonal_email();
        this.city=personaInputDto.getCity();
        this.active=personaInputDto.getActive();
       // this.created_date=personaInputDto.getCreated_date();
        this.imagen_url=personaInputDto.getImagen_url();
        this.termination_date=personaInputDto.getTermination_date();
    }



}
