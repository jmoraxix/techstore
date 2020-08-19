package com.techstore.web.controller;

import com.techstore.web.dao.MarcaRepository;
import com.techstore.web.dao.MarcaRepository;
import com.techstore.web.model.Marca;
import com.techstore.web.model.TipoPago;
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
@RequestMapping("/admin/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/")
    public ModelAndView listarMarcas(ModelMap model) {
        List<Marca> listaMarcas = marcaRepository.findAll();
        model.addAttribute("listaMarcas", listaMarcas);
        return new ModelAndView("marcas/listar-marcas", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearMarca(ModelMap model) {
        model.addAttribute("marca", new Marca());
        model.addAttribute("modo","crear");
        return new ModelAndView("marcas/editar-marca", model);
    }


    @PostMapping(value = "/crear")
    public ModelAndView guardarMarca(@Valid @ModelAttribute("marca") Marca marca, BindingResult result, RedirectAttributes redirectAttrs) {
        marcaRepository.save(marca);
        redirectAttrs.addFlashAttribute("mensaje", "Nueva marca creada");
        return new ModelAndView("redirect:/admin/marcas/");
    }


    @GetMapping("/{marcaId}")
    public ModelAndView mostrarMarca(@PathVariable Long marcaId, ModelMap model) {
        Optional<Marca> marca = marcaRepository.findById(marcaId);
        model.addAttribute("marca", marca.get());
        return new ModelAndView("marcas/ver-marca", model);
    }


    @GetMapping("/editar/{marcaId}")
    public ModelAndView editarMarca(@PathVariable Long marcaId, ModelMap model) {
        Optional<Marca> marca = marcaRepository.findById(marcaId);
        model.addAttribute("marca", marca.get());
        model.addAttribute("modo","editar");
        return new ModelAndView("marcas/editar-marca", model);
    }


    @PostMapping("/editar/{marcaId}")
    public ModelAndView updateMarca(@Valid @ModelAttribute("marca") Marca marca, BindingResult result, RedirectAttributes redirectAttrs) {
        marcaRepository.save(marca);
        redirectAttrs.addFlashAttribute("mensaje", "Marca actualizada exitosamente");
        return new ModelAndView("redirect:/admin/marcas/");
    }

    @GetMapping("/eliminar/{marcaId}")
    public ModelAndView deleteMarca(@PathVariable Long marcaId, RedirectAttributes redirectAttrs) {
        marcaRepository.deleteById(marcaId);
        redirectAttrs.addFlashAttribute("mensaje", "Marca eliminada exitosamente");
        return new ModelAndView("redirect:/admin/marcas/");
    }
}

