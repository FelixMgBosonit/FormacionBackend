package com.bosonit.formacion.block7crudvalidation.student.controller.dto.studentOutputDto;

import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDtoFull extends StudentOutputDtoSimple {

    private Integer idPersona;
    private String usuario;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createdDate;
    private String imagenUrl;
    private Date terminationDate;

    public StudentOutputDtoFull(Student student) {
        super(student);
        this.idPersona = student.getPersona().getIdPersona();
        this.usuario = student.getPersona().getUsuario();
        this.name = student.getPersona().getName();
        this.surname = student.getPersona().getSurname();
        this.companyEmail = student.getPersona().getCompanyEmail();
        this.personalEmail = student.getPersona().getPersonalEmail();
        this.city = student.getPersona().getCity();
        this.active = student.getPersona().getActive();
        this.createdDate = student.getPersona().getCreatedDate();
        this.imagenUrl = student.getPersona().getImagenUrl();
        this.terminationDate = student.getPersona().getTerminationDate();

    }
}

