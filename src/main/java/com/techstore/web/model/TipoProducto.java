package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="tipo_producto")
public class TipoProducto {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
}
