package com.techstore.web.dao;

import com.techstore.web.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    List<Factura> findByOrderByFecha();

    List<Factura> findByOrdenUsuarioNombreUsuarioOrderByFecha(String nombreUsuario);
}
