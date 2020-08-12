package com.techstore.web.dao;

import com.techstore.web.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query(value="SELECT o.* FROM orden o WHERE o.usuario_nombre_usuario = :nombreUsuario AND o.activa = TRUE LIMIT 1", nativeQuery = true)
    Orden getOrdenActiva(String nombreUsuario);

}
