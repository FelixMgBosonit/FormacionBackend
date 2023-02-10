package com.bosonit.formacion.block7crudvalidation.persona.exception;

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
