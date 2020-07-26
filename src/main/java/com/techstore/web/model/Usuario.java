package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="usuario")
public class Usuario {

    @Id
    private String nombreUsuario;

    @NotNull
    @Column(unique=true)
    private String cedula;

    @NotNull
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

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private RolUsuario rolUsuario;
}
