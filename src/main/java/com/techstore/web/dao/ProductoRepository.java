package com.techstore.web.dao;
import com.techstore.web.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
