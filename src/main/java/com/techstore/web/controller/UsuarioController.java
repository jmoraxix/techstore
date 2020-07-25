package com.techstore.web.controller;

import com.techstore.web.dao.RolUsuarioRepository;
import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.Usuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    @GetMapping("/")
    public ModelAndView listarUsuarios(ModelMap model){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return new ModelAndView("usuarios/listar-usuarios", model);
    }
    
    @GetMapping("/crear")
    public ModelAndView crearUsuario(ModelMap model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listaRoles", rolUsuarioRepository.findAll());
        model.addAttribute("modo", "crear");
        return new ModelAndView("usuarios/editar-usuario", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarNuevoUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes redirectAttrs) {
        usuarioRepository.save(usuario);
        redirectAttrs.addFlashAttribute("mensaje", "Usuario creado exitosamente");
        return new ModelAndView("redirect:/usuarios/");
    }

    @GetMapping("/{nombreUsuario}")
    public ModelAndView mostrarUsuario(@PathVariable String nombreUsuario, ModelMap model){
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        model.addAttribute("usuario", usuario);
        return new ModelAndView("usuarios/ver-usuario", model);
    }

    @GetMapping("/editar/{nombreUsuario}")
    public ModelAndView editarUsuario(@PathVariable String nombreUsuario, ModelMap model){
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaRoles", rolUsuarioRepository.findAll());
        model.addAttribute("modo", "editar");
        return new ModelAndView("usuarios/editar-usuario", model);
    }

    @PostMapping(value = "/editar/{nombreUsuario}")
    public ModelAndView guardarEditarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes redirectAttrs) {
        usuarioRepository.save(usuario);
        redirectAttrs.addFlashAttribute("mensaje", "Usuario actualizado exitosamente");
        return new ModelAndView("redirect:/usuarios/");
    }

    @GetMapping("/eliminar/{nombreUsuario}")
    public ModelAndView eliminarUsuario(@PathVariable String nombreUsuario, RedirectAttributes redirectAttrs){
        usuarioRepository.deleteByNombreUsuario(nombreUsuario);
        redirectAttrs.addFlashAttribute("mensaje", "Usuario eliminado exitosamente");
        return new ModelAndView("redirect:/usuarios/");
    }
}
