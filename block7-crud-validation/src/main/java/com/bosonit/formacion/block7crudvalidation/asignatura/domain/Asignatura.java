package com.bosonit.formacion.block7crudvalidation.asignatura.domain;

import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_Asignatura",unique = true)
    private Integer idAsignatura;
    @Column(unique = true)
    private String nombreAsignatura;
    private String comments;
    private String branch;
    @Column(nullable = false)
    private Date initial_date= new Date();
    private Date finish_date;


    //------------------------Relaciones------------------------
    @ManyToMany(mappedBy = "asignaturas")//, cascade=CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
    // ----------------------------------------------------------


}
