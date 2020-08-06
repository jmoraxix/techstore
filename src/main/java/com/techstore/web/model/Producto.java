package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
@Data
@Entity
@Validated
@Cacheable
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String nombre;

    @NotNull
    private Double precio;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Marca marca;

    @NotNull
    private String modelo;

    @NotNull
    private String descripcion;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoProducto tipoProducto;
}

