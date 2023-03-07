package com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCabecera")
    private CabeceraFra cabeceraFra;

    //----------------------------------------------------------
}
