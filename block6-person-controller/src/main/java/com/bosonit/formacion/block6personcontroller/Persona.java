package com.bosonit.formacion.block6personcontroller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@Data tan solo genera el constructor vacío.
//Por ello se debe crear el constructor con parámetros
//U otra opción es añadir la notación @AllArgsConstructor
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String poblacion;
    private int edad;


//    public Persona(String nombre, String poblacion, int edad) {
//        this.nombre = nombre;
//        this.poblacion = poblacion;
//        this.edad = edad;
//    }
    
}
