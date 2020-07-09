package com.techstore.web.dao;

import com.techstore.web.model.RolUsuario;
import com.techstore.web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {
}
