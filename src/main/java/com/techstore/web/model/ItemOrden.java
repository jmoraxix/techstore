package com.techstore.web.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Validated
@Table(name="item_orden")
public class ItemOrden {
    @Id
    private Long id;

    @MapsId
    @ManyToOne(fetch= FetchType.EAGER)
    private Orden orden;

    @MapsId
    @ManyToOne(fetch= FetchType.EAGER)
    private Producto producto;

    @NotNull
    private int cantidad;

}
