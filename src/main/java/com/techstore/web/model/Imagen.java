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
    private int imagen_id;

    @NotNull
    private Blob imagen;

    @NotNull
    private String imagen_nombre;

    @NotNull
    private String ubicacion;


}
