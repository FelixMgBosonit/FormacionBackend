package com.bosonit.formacion.block7crudvalidationCORS.student.controller.dto.studentInputDto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    private Integer idPersona;
    private Integer numHourWeek;
    private String comments;
    private String branch;
}