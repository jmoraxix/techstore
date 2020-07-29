package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="inventario")
public class Inventario {

    @Id
    private Long id;

    @MapsId
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursal;

    @MapsId
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;

    @NotNull
    private int cantidad;
}














