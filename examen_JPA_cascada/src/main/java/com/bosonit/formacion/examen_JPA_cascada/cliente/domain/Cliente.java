package com.bosonit.formacion.examen_JPA_cascada.cliente.domain;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", unique = true)
    private Integer idCliente;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombreCliente;


    //------------------------Relaciones------------------------
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", orphanRemoval = true)
    private List<CabeceraFra> cabeceraFraList = new ArrayList<>();

    //----------------------------------------------------------


}
