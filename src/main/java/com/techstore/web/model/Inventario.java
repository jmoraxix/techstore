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
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sucursal_id", referencedColumnName="id")
    private Sucursal sucursal;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id", referencedColumnName="id")
    private Producto producto;

    @NotNull
    private int cantidad;
}














