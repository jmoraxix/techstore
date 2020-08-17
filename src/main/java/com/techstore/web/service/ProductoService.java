package com.techstore.web.service;

import com.techstore.web.dao.ProductoRepository;
import com.techstore.web.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long productoId){
        return productoRepository.findFirstById(productoId);
    }
}
