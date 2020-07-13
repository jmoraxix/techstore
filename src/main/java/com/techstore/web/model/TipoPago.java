package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name = "tipo_pago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @NotNull
    private String nombre;

    private String descripcion;
}
