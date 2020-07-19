package com.techstore.web.controller;

import com.techstore.web.dao.CategoriaRepository;
import com.techstore.web.model.Categoria;
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
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public ModelAndView listarCategorias(ModelMap model){
        List<Categoria> listaCategorias=categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return new ModelAndView("categorias/listar-categorias", model);
    }
}
