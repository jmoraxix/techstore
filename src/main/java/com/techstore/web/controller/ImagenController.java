package com.techstore.web.controller;

import com.techstore.web.dao.ImagenRepository;
import com.techstore.web.model.Imagen;
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
@RequestMapping("/imagenes")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;

    @GetMapping("/")
    public ModelAndView listarImagenes(ModelMap model) {
        List<Imagen> listaImagenes = imagenRepository.findAll();
        model.addAttribute("listaImagenes", listaImagenes);
        return new ModelAndView("imagenes/listar-imagen", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearImagen(ModelMap model, @RequestHeader("referer") String referer) {
        model.addAttribute("imagen", new Imagen());
        model.addAttribute("urlAtras", referer);
        return new ModelAndView("imagenes/editar-imagen", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarImagen(@Valid @ModelAttribute("imagen") Imagen imagen, BindingResult result, RedirectAttributes redirectAttrs) {
        imagenRepository.save(imagen);
        redirectAttrs.addFlashAttribute("mensaje", "Nueva imagen creada");
        return new ModelAndView("redirect:/imagenes/");
    }

    @GetMapping("/{imagenId}")
    public ModelAndView mostrarImagen(@PathVariable long imagenId, ModelMap model, @RequestHeader("referer") String referer) {
        Optional<Imagen> imagen = imagenRepository.findById(imagenId);
        model.addAttribute("imagen", imagen.get());
        model.addAttribute("urlAtras", referer);
        return new ModelAndView("imagenes/ver-imagen", model);
    }

    @GetMapping("/editar/{imagenId}")
    public ModelAndView editarImagen(@PathVariable Long imagenId, ModelMap model, @RequestHeader("referer") String referer) {
        Optional<Imagen> imagen = imagenRepository.findById(imagenId);
        model.addAttribute("imagen", imagen.get());
        model.addAttribute("urlAtras", referer);
        return new ModelAndView("imagenes/editar-imagen", model);
    }

    @PostMapping("/editar/{imagenId}")
    public ModelAndView actualizarImagen(@Valid @ModelAttribute("imagen") Imagen imagen, BindingResult result, RedirectAttributes redirectAttrs) {
        imagenRepository.save(imagen);
        redirectAttrs.addFlashAttribute("mensaje", "Imagen actualizada exitosamente");
        return new ModelAndView("redirect:/imagenes/");
    }

    @GetMapping("/eliminar/{imagenId}")
    public ModelAndView eliminarImagen(@PathVariable Long imagenId, RedirectAttributes redirectAttrs){
        imagenRepository.deleteById(imagenId);
        redirectAttrs.addFlashAttribute("mensaje","Imagen eliminada exitosamente");
        return new ModelAndView("redirect:/imagenes/");
    }

}
