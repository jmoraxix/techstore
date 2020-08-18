package com.techstore.web.dao;

import com.techstore.web.model.ItemOrden;
import com.techstore.web.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrdenRepository extends JpaRepository<ItemOrden, Long> {

	List<ItemOrden> findAllByOrden(Orden orden);
}
