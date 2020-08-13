package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name = "rol_usuario")
public class RolUsuario implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String nombre;

    private String descripcion;

    @Override
    public String getAuthority() {
        return nombre.toUpperCase();
    }
}
