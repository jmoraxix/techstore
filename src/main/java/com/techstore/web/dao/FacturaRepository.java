package com.techstore.web.dao;

import com.techstore.web.model.Factura;
import com.techstore.web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query("SELECT f FROM Factura f WHERE f.orden.usuario = :usuario ORDER BY fecha DESC")
    List<Factura> getOrdenesFromUsuario(Usuario usuario);
}
