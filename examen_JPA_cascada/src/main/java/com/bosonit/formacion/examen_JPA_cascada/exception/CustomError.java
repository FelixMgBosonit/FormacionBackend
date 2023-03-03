package com.bosonit.formacion.examen_JPA_cascada.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomError {
    private Date timeStamp;
    private int HttpCode;
    private String mensaje;
}
