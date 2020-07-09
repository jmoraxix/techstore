package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Validated
@Table(name="usuario")
public class Usuario {

    @Id
    private String usuario;

    @NotNull
    @Column(unique=true)
    private String cedula;

    private String contrasena;

    @NotNull
    @Column(unique=true)
    private String correo;

    @NotNull
    private String nombre;

    @NotNull
    private String primerApellido;

    private String segundoApellido;

    private String telefono;

    private String direccion;
}
