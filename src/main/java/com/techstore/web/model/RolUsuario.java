package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="rol_usuario")
public class RolUsuario {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String nombre;

    private String descripcion;

}
