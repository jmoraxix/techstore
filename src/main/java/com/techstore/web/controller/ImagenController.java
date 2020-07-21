package com.techstore.web.controller;

import com.techstore.web.dao.ImagenRepository;
import com.techstore.web.model.Imagen;
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
@RequestMapping("/imagen")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;

    @GetMapping("/")
    public ModelAndView listarImagenes(ModelMap model){
        List<Imagen> listaImagenes=imagenRepository.findAll();
        model.addAttribute("listaImaneges", listaImagenes);
        return new ModelAndView("imagen/listar-imagenes", model);
    }
}
