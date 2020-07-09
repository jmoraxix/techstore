package com.techstore.web.controller;

import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.Usuario;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public ModelAndView listarUsuarios(ModelMap model){
        // Buscamos todos los usuarios de la BD
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        //Asignamos la lista a un atributo del modelo que va a ver Thymeleaf
        model.addAttribute("listaUsuarios", listaUsuarios);
        // Retornamos la vista con el modelo
        return new ModelAndView("usuarios/listar-usuarios", model);
    }
}
