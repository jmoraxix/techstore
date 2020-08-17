package com.techstore.web.controller;

import com.techstore.web.dao.RolUsuarioRepository;
import com.techstore.web.model.RolUsuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/crear")
    public ModelAndView crearRol(ModelMap model){
        model.addAttribute("rol", new RolUsuario());
        model.addAttribute("modo", "crear");
        return new ModelAndView("roles/editar-rol", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarNuevoRol(@Valid @ModelAttribute("rol") RolUsuario rol, BindingResult result, RedirectAttributes redirectAttrs) {
        rolUsuarioRepository.save(rol);
        redirectAttrs.addFlashAttribute("mensaje", "Rol creado exitosamente");
        return new ModelAndView("redirect:/admin/usuarios/roles/");
    }

    @GetMapping("/{rolId}")
    public ModelAndView mostrarRol(@PathVariable Long rolId, ModelMap model){
        Optional<RolUsuario> rolUsuario = rolUsuarioRepository.findById(rolId);
        model.addAttribute("rol", rolUsuario.get());
        return new ModelAndView("roles/ver-rol", model);
    }

    @GetMapping("/editar/{rolId}")
    public ModelAndView editarRol(@PathVariable Long rolId, ModelMap model){
        Optional<RolUsuario> rolUsuario = rolUsuarioRepository.findById(rolId);
        model.addAttribute("rol", rolUsuario.get());
        model.addAttribute("modo", "editar");
        return new ModelAndView("roles/editar-rol", model);
    }

    @PostMapping(value = "/editar/{rolId}")
    public ModelAndView guardarEditarRol(@Valid @ModelAttribute("rol") RolUsuario rol, BindingResult result, RedirectAttributes redirectAttrs) {
        rolUsuarioRepository.save(rol);
        redirectAttrs.addFlashAttribute("mensaje", "Rol actualizado exitosamente");
        return new ModelAndView("redirect:/admin/usuarios/roles/");
    }

    @GetMapping("/eliminar/{rolId}")
    public ModelAndView eliminarRol(@PathVariable Long rolId, RedirectAttributes redirectAttrs){
        rolUsuarioRepository.deleteById(rolId);
        redirectAttrs.addFlashAttribute("mensaje", "Rol eliminado exitosamente");
        return new ModelAndView("redirect:/usuarios/roles/");
    }
}
