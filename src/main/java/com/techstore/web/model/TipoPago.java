package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="tipo_pago")
public class TipoPago {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nombre;

    private String descripcion;
}
