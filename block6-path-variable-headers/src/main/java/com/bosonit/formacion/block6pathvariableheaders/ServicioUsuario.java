package com.bosonit.formacion.block6pathvariableheaders;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ServicioUsuario {
    private Usuario usuario;

    private HashMap<String,String > peticionPut = new HashMap<String, String >();

    public Usuario creaUsuario (int id, String nombre){
        usuario= new Usuario(id,nombre);

        return  usuario;
    }

    public HashMap creaHashMap (String var1, String var2){
        peticionPut.put("var1",var1);
        peticionPut.put("var2",var2);
        return  peticionPut;

    }



}
