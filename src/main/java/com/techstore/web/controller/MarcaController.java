package com.techstore.web.controller;

import com.techstore.web.dao.MarcaRepository;
import com.techstore.web.dao.MarcaRepository;
import com.techstore.web.model.Marca;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@Log4j2
@RequestMapping("/marcas")

public class MarcaController{

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/")
    public ModelAndView listarMarcas(ModelMap model){

        List<Marca> listaMarcas=marcaRepository.findAll();

        model.addAttribute("listaMarcas", listaMarcas);

        return new ModelAndView("marcas/listar-marcas", model);
    }
}
