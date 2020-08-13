package com.techstore.web.dao;

import com.techstore.web.model.Orden;
import com.techstore.web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    Orden findFirstByUsuarioAndActivaTrue(Usuario usuario);

}
