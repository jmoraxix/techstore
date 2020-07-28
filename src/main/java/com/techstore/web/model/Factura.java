package com.techstore.web.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@Validated
@Table(name="factura")
public class Factura {
    @Id
    private long id;

    @OneToOne
    @MapsId
    private Orden orden;

    @NotNull
    private Date fecha;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoPago tipoPago;
}
