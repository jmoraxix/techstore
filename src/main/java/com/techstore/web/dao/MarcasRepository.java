package com.techstore.web.dao;

import com.techstore.web.model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long> {
}
