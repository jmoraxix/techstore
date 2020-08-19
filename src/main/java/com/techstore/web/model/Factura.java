package com.techstore.web.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Validated
@Table(name="factura")
public class Factura {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Orden orden;

    private Date fecha;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoPago tipoPago;

    public void facturar(){
        this.orden.setActiva(false);
    }
}
