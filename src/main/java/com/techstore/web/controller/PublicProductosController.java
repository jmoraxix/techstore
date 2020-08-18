package com.techstore.web.controller;

import com.techstore.web.dao.ImagenRepository;
import com.techstore.web.dao.ProductoRepository;
import com.techstore.web.model.Producto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
@Log4j2
public class PublicProductosController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ImagenRepository imagenRepository;


    @GetMapping("/{productoId}")
    public ModelAndView mostrarProductio(ModelMap model, @PathVariable Long productoId){
        Optional<Producto> producto=productoRepository.findById(productoId);
        model.addAttribute("producto",producto.get());
        //TODO buscar imagen por cada producto
        return new ModelAndView("publicproducto/public-producto",model);
    }
}
