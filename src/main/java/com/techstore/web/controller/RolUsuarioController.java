package com.techstore.web.controller;

import com.techstore.web.dao.RolUsuarioRepository;
import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.RolUsuario;
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
@RequestMapping("/usuarios/roles")
public class RolUsuarioController {

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    @GetMapping("/")
    public ModelAndView listarRoles(ModelMap model){
        List<RolUsuario> listaRoles = rolUsuarioRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        return new ModelAndView("roles/listar-roles", model);
    }
}
