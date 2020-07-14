package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@Validated
@Table(name="marcas")
public class Marcas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @NotNull
    private String nombre;


}
