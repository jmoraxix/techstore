package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Validated
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    private String nombreUsuario;

    @NotNull
    @Column(unique = true)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_nombre_usuario"), inverseJoinColumns = @JoinColumn(name = "rol_usuario_id"))
    private Set<RolUsuario> rolUsuario;

    public void addRolUsuario(RolUsuario nuevoRol){
        if(rolUsuario == null) rolUsuario = new HashSet<>();
        rolUsuario.add(nuevoRol);
    }

    public Set<RolUsuario> getRolUsuario(){
        return rolUsuario != null? rolUsuario : new HashSet<RolUsuario>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rolUsuario;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
