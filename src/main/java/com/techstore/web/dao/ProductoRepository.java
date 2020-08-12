package com.techstore.web.dao;
import com.techstore.web.model.Producto;
import com.techstore.web.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.tipoProducto = :tipoProducto")
    List<Producto> getAllFromTipoProductos(TipoProducto tipoProducto);

    @Query("SELECT p FROM Producto p WHERE p.tipoProducto IN :listaProductos")
    List<Producto> getAllFromListaTipoProductos(List<TipoProducto> listaProductos);

    Producto findFirstById(Long id);
}
