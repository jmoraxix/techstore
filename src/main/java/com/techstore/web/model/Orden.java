package com.techstore.web.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Validated
@Table(name="orden")
public class Orden {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(fetch= FetchType.LAZY)
    private Usuario usuario;

    @NotNull
    private boolean activa = true;

    @OneToMany
    @JoinColumn(name="orden_id", referencedColumnName="id")
    private List<ItemOrden> items;

}
