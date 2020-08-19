package com.techstore.web.model;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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

    @Nullable
    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="orden")
    private List<ItemOrden> items;

    public List<ItemOrden> getItems(){
        return items != null ? items : new ArrayList<ItemOrden>();
    }

}
