package com.bosonit.formacion.block7crud;

import java.util.List;

public interface PersonaService {

    public void addPersona(Persona persona);
    public void updatePersona(Long id, Persona persona);
    public void deletePersona(Long id);
    public Persona getPersonaById(Long id);
    public List<Persona> getPersonasByName(String name);
    public List<Persona> getAllPersonas();
}
