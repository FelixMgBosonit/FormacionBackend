package com.bosonit.formacion.block6personcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador/bean")
public class ControladorBean {
    @Autowired
    @Qualifier("bean1")
    private Persona personaBean1;

    @Autowired
    @Qualifier("bean2")
    private Persona personaBean2;

    @Autowired
    @Qualifier("bean3")
    private Persona personaBean3;

    @GetMapping("/{bean}")
    public Persona getBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return personaBean1;
            case "bean2":
                return personaBean2;
            case "bean3":
                return personaBean3;
            default:
                throw new IllegalArgumentException("Bean no encontrado");
        }
    }




}
