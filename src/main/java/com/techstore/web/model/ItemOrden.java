package com.techstore.web.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Validated
@Table(name="item_orden")
public class ItemOrden {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="orden_id", nullable=false)
    @ToString.Exclude
    private Orden orden;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn
    private Producto producto;

    @NotNull
    private int cantidad;

    public Double getSubtotal(){
        return producto.getPrecio() * cantidad;
    }
}
