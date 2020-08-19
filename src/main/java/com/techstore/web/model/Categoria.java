package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Validated
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String nombre;

    private Integer orden=1;

    @OneToMany
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ToString.Exclude
    private List<TipoProducto> tipoProductos;
}
