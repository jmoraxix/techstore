package com.techstore.web.dao;

import com.techstore.web.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SucursalRepository  extends JpaRepository<Sucursal,Long>{

    //Sucursal findById(Long Id);


}
