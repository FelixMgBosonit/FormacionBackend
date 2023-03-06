package com.bosonit.formacion.examen_JPA_cascada.inicio;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.repository.CabeceraFraRepository;
import com.bosonit.formacion.examen_JPA_cascada.cliente.domain.Cliente;
import com.bosonit.formacion.examen_JPA_cascada.cliente.repository.ClienteRepository;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain.LineaFra;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.repository.LineaFraRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponenteInicio {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Autowired
    LineaFraRepository lineaFraRepository;

    @PostConstruct
    public void cargaDatos (){

        Cliente cliente = new Cliente();
        cliente.setNombreCliente("Ficticia1");
        clienteRepository.save(cliente);


        CabeceraFra cabeceraFra=new CabeceraFra();
        cabeceraFra.setImporteFra(1000.0);
        cabeceraFra.setCliente(cliente);



        LineaFra lineaFra1=new LineaFra();
        lineaFra1.setProductoNombre("Producto 1");
        lineaFra1.setCantidad(20.0);
        lineaFra1.setPrecio(200.0);
        lineaFra1.setCabeceraFra(cabeceraFra);

        LineaFra lineaFra2=new LineaFra();
        lineaFra2.setProductoNombre("Producto 2");
        lineaFra2.setCantidad(50.0);
        lineaFra2.setPrecio(500.0);
        lineaFra2.setCabeceraFra(cabeceraFra);


        cabeceraFra.getLineaFraList().add(lineaFra1);
        cabeceraFra.getLineaFraList().add(lineaFra2);


        cabeceraFraRepository.save(cabeceraFra);

    }

}
