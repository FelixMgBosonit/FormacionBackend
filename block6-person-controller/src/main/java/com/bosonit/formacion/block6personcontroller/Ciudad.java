package com.bosonit.formacion.block6personcontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
public class Ciudad {
    private String nombre;
    private int numHabitantes;
}
