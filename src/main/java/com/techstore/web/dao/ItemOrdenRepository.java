package com.techstore.web.dao;

import com.techstore.web.model.ItemOrden;
import com.techstore.web.model.Orden;
import com.techstore.web.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ItemOrdenRepository extends JpaRepository<ItemOrden, Long> {

	Set<ItemOrden> findAllByProducto(Producto producto);

	Set<ItemOrden> findAllByOrden(Orden orden);
}
