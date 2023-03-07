package com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain;

import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain.LineaFra;
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
public class CabeceraFra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCabecera", unique = true)
    private Integer idCabeceraFra;

    @Column(name = "importeFra")
    private Double importeFra;

    //------------------------Relaciones------------------------
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "cabeceraFra",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaFra> lineaFraList=new ArrayList<>();

    //----------------------------------------------------------

}
