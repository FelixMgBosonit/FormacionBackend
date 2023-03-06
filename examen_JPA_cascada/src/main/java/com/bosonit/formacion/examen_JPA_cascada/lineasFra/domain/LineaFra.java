package com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
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
public class LineaFra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLineaFra", unique = true)
    private Integer idLineaFra;
    @Column(name="proNomb", nullable = false)
    private String productoNombre;
    private Double cantidad;
    private Double precio;

    //------------------------Relaciones------------------------
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="idCabeceraFra")
    private CabeceraFra cabeceraFra;



    //----------------------------------------------------------
}
