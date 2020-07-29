package com.techstore.web.dao;

import com.techstore.web.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
}
