package com.bosonit.formacion.block7crud;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
//    private Persona Persona = new Persona();//
    private List<Persona> ListaPersonas = new ArrayList<>();


    @Override
    public void addPersona(Persona persona) {
        persona = new Persona(persona.getId(), persona.getNombre(), persona.getEdad(), persona.getPoblacion());
        ListaPersonas.add(persona);

    }

    @Override
    public void updatePersona(Long id, Persona persona) {
        for (Persona p : ListaPersonas) {
            if (p.getId() == id) {
                p.setNombre(persona.getNombre());
                p.setEdad(persona.getEdad());
                p.setPoblacion(persona.getPoblacion());

            }
        }
    }



    @Override
    public void deletePersona(Long id) {

            //-----------------Forma 1 de borrar-------------------------
            //            for (int i = 0; i < ListaPersonas.size(); i++) {
            //                Persona p = ListaPersonas.get(i);
            //                if (p.getId() == id) {
            //                    ListaPersonas.remove(i);
            //                    break;
            //                }
            //            }
            //----------------------Forma 2 de borrar con iterador --------------------------
            //        Iterator<Persona> iterator = ListaPersonas.iterator();
            //        while (iterator.hasNext()) {
            //            Persona p = iterator.next();
            //            if (p.getId() == id) {
            //                iterator.remove();
            //            }
            //        }

            //----------------------Forma 3 de borrar con lambda --------------------------
            ListaPersonas.removeIf(p -> p.getId() == id);



    }

            @Override
            public Persona getPersonaById (Long id){
            //----------------------------------------------------------------------------------------------
            //        Persona personaEncontrada= new Persona();
            //        for(Persona persona : ListaPersonas){
            //            if(persona.getId().equals(id)){
            //                personaEncontrada=persona;
            //            }
            //        }
            //        return personaEncontrada;
            // Este método inicial siempre va a devolver una persona aunque sea vacía por el constructor vacío...
            // Con lo que en el método del controller nunca entraría en el else...

            //-------------------------------------------------------------------------------------------------
                for (Persona p : ListaPersonas) {
                    if (p.getId().equals(id)) return p;
                }
                return null;
            }


            @Override
            public List<Persona> getPersonasByName (String nombre){
                List<Persona> PersonasEncontradas = new ArrayList<>();//Creo una nueva lista para diferenciar la lista total de la lista de personas encontradas
                for (Persona personas : ListaPersonas) {
                    if (personas.getNombre().equalsIgnoreCase(nombre)) {
                        PersonasEncontradas.add(personas);
                    }
                }
                return PersonasEncontradas;
            }


            @Override
            public List<Persona> getAllPersonas () {
                return ListaPersonas;
            }
        }
