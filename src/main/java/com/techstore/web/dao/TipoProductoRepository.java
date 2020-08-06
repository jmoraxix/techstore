package com.techstore.web.dao;

import com.techstore.web.model.Categoria;
import com.techstore.web.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    @Query("Select tp from TipoProducto tp where tp.categoria = :categoria")
    List<TipoProducto> getTipoProductByCategoria(Categoria categoria);
}
