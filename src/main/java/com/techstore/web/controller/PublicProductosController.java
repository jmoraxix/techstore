package com.techstore.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/producto")
@Log4j2
public class PublicProductosController {

    @GetMapping("/{productoId}")
    public ModelAndView mostrarProductio(ModelMap model, @PathVariable Long productoId){


        return new ModelAndView("publicproducto/public-producto",model);
    }
}
