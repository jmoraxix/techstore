package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String nombre;
}
