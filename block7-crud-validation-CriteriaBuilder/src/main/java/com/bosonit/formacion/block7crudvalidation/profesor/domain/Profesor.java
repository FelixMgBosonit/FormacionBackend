package com.bosonit.formacion.block7crudvalidation.profesor.domain;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_profesor", unique = true)
    private Integer idProfesor;

    private String comments;

    @Column(nullable = false)
    private String branch;


    //------------------------Relaciones------------------------
    @OneToOne //(cascade = CascadeType.ALL)//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = true, unique = true)
    private Persona persona;
    @OneToMany(mappedBy = "profesor")//,cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    //----------------------------------------------------------

}
