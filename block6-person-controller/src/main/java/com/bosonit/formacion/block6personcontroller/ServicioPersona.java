package com.bosonit.formacion.block6personcontroller;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ServicioPersona {

    private Persona persona;
    public Persona creaPersona(String nombre, String poblacion, int edad) {
        persona=new Persona(nombre, poblacion,edad);
        return persona;
    }
//@Data ahorraría el getPersona además de los getters y setters de los campos

//    public Persona getPersona() {
//        return persona;
//    }
}
