package com.techstore.web.controller;

import com.techstore.web.dao.RolUsuarioRepository;
import com.techstore.web.model.Usuario;
import com.techstore.web.service.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@Log4j2
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    @GetMapping("/")
    public ModelAndView guardarNuevoUsuario(RedirectAttributes redirectAttrs) {
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/login")
    public ModelAndView mostrarLogin(ModelMap model) {
        return new ModelAndView("login/iniciar-sesion", model);
    }

    @GetMapping("/crearusuario")
    public ModelAndView crearUsuario(ModelMap model) {
        model.addAttribute("usuario", new Usuario());
        return new ModelAndView("usuarios/crear-usuario-public", model);
    }

    @PostMapping("/crearusuario")
    public ModelAndView guardarNuevoUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes redirectAttrs) {
        usuario.addRolUsuario(rolUsuarioRepository.findFirstByNombre("Cliente"));
        usuarioService.save(usuario);
        redirectAttrs.addFlashAttribute("mensaje", "Usuario creado exitosamente");
        return new ModelAndView("redirect:/login");
    }

}
