package com.techstore.web.controller;

import com.techstore.web.dao.CategoriaRepository;
import com.techstore.web.model.Categoria;
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
@RequestMapping("/admin/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public ModelAndView listarCategorias(ModelMap model){
        List<Categoria> listaCategorias=categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return new ModelAndView("categorias/listar-categorias", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearCategoria(ModelMap model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("modo", "crear");
        return new ModelAndView("categorias/editar-categoria", model);
    }


    @PostMapping(value = "/crear")
    public ModelAndView guardarCategoria(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, RedirectAttributes redirectAttrs) {
        categoriaRepository.save(categoria);
        redirectAttrs.addFlashAttribute("mensaje", "Nueva categoria creada");
        return new ModelAndView("redirect:/admin/categorias/");
    }


    @GetMapping("/{categoriaId}")
    public ModelAndView mostrarCategoria(@PathVariable Long categoriaId, ModelMap model) {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
        model.addAttribute("categoria", categoria.get());
        return new ModelAndView("categorias/ver-categoria", model);
    }


    @GetMapping("/editar/{categoriaId}")
    public ModelAndView editarCategoria(@PathVariable Long categoriaId, ModelMap model) {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
        model.addAttribute("categoria", categoria.get());
        model.addAttribute("modo", "editar");
        return new ModelAndView("categorias/editar-categoria", model);
    }


    @PostMapping("/editar/{categoriaId}")
    public ModelAndView updateCategoria(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, RedirectAttributes redirectAttrs) {
        categoriaRepository.save(categoria);
        redirectAttrs.addFlashAttribute("mensaje", "Categoria actualizada exitosamente");
        return new ModelAndView("redirect:/admin/categorias/");
    }

    @GetMapping("/eliminar/{categoriaId}")
    public ModelAndView deleteCategoria(@PathVariable Long categoriaId, RedirectAttributes redirectAttrs) {
        categoriaRepository.deleteById(categoriaId);
        redirectAttrs.addFlashAttribute("mensaje", "Categoria eliminada exitosamente");
        return new ModelAndView("redirect:/admin/categorias/");
    }
}

