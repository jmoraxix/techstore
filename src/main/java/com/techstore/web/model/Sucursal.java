package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="sucursal")
public class Sucursal {
    @Id
    @Column(unique = true)
    private Long codigo;

    @NotNull
    private String provincia;

    @NotNull
    private String canton;

    @NotNull
    private String distrito;

    @NotNull
    @Column(unique=true)
    private String telefono;

}
