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
    private Long id;

    @NotNull
    @Column(unique=true)
    private String nombre;

    private String descripcion;

}
