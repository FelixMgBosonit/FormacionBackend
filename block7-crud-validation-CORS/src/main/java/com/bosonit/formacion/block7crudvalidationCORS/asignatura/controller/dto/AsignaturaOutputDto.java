package com.bosonit.formacion.block7crudvalidationCORS.asignatura.controller.dto;

import com.bosonit.formacion.block7crudvalidationCORS.asignatura.domain.Asignatura;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {

    private Integer idAsignatura;
    private String nombreAsignatura;
    private String comments;
    private String branch;
    private Date initial_date;
    private Date finish_date;

    public AsignaturaOutputDto(Asignatura asignatura) {
        this.idAsignatura = asignatura.getIdAsignatura();
        this.nombreAsignatura = asignatura.getNombreAsignatura();
        this.comments = asignatura.getComments();
        this.branch = asignatura.getBranch();
        this.initial_date = asignatura.getInitial_date();
        this.finish_date = asignatura.getFinish_date();
    }
}
