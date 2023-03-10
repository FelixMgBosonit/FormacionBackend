package com.bosonit.formacion.block7crudvalidation.student.controller.dto.studentOutputDto;

import com.bosonit.formacion.block7crudvalidation.asignatura.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDtoSimple {
    private Integer idStudent;
    private Integer numHourWeek;
    private String comments;
    private String branch;
    //---------------------------------------------------------
    private List<AsignaturaOutputDto> listAsignaturas = new ArrayList<>();
    //--------------------------------------------------------

    public StudentOutputDtoSimple(Student student) {
        this.idStudent = student.getIdStudent();
        this.numHourWeek = student.getNumHourWeek();
        this.comments = student.getComments();
        this.branch = student.getBranch();
        this.listAsignaturas = student.getAsignaturas().stream().map(AsignaturaOutputDto::new).toList();

    }
}
