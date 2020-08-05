package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
@Validated
@Table(name = "imagen")

public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private Long imagenId;


    @NotNull
    private String imagenNombre;

    @NotNull
    private String ubicacion;


}
