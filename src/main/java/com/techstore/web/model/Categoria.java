package com.techstore.web.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Validated
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique=true)
    private String nombre;
}
