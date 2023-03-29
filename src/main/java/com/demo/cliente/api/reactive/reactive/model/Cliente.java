package com.demo.cliente.api.reactive.reactive.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Cliente {
    @Id
    private int id;
    private String identificacion;

    private String nombre;
    private String apellido;
    private String paisResidencia;

    private String paisNacimiento;

    private String direccion;

    private String telefono;

}
