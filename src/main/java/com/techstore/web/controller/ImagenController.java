package com.techstore.web.controller;

import com.techstore.web.dao.ImagenRepository;
import com.techstore.web.model.Imagen;
import com.techstore.web.service.ProductoService;
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
@RequestMapping("/admin/imagenes")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ModelAndView listarImagenes(ModelMap model) {
        List<Imagen> listaImagenes = imagenRepository.findAll();
        model.addAttribute("listaImagenes", listaImagenes);
        return new ModelAndView("imagenes/listar-imagen", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearImagen(ModelMap model) {
        model.addAttribute("imagen", new Imagen());
        model.addAttribute("listaProductos", productoService.findAll());
        model.addAttribute("modo", "crear");
        return new ModelAndView("imagenes/editar-imagen", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarImagen(@Valid @ModelAttribute("imagen") Imagen imagen, BindingResult result, RedirectAttributes redirectAttrs) {
        imagenRepository.save(imagen);
        redirectAttrs.addFlashAttribute("mensaje", "Nueva imagen creada");
        return new ModelAndView("redirect:/admin/imagenes/");
    }

    @GetMapping("/{imagenId}")
//    @RequestMapping(value = "/imagenes/{imagenId}", method = RequestMethod.GET)
    public ModelAndView mostrarImagen(@PathVariable long imagenId, ModelMap model, @RequestHeader("referer") String referer) {
        Optional<Imagen> imagen = imagenRepository.findById(imagenId);
        model.addAttribute("imagen", imagen.get());
        model.addAttribute("urlAtras", referer);
        return new ModelAndView("imagenes/ver-imagen", model);
    }

    @GetMapping("/editar/{imagenId}")
    public ModelAndView editarImagen(@PathVariable Long imagenId, ModelMap model) {
        Optional<Imagen> imagen = imagenRepository.findById(imagenId);
        model.addAttribute("imagen", imagen.get());
        model.addAttribute("modo", "editar");
        return new ModelAndView("imagenes/editar-imagen", model);
    }

    @PostMapping("/editar/{imagenId}")
    public ModelAndView actualizarImagen(@Valid @ModelAttribute("imagen") Imagen imagen, BindingResult result, RedirectAttributes redirectAttrs) {
        imagenRepository.save(imagen);
        redirectAttrs.addFlashAttribute("mensaje", "Imagen actualizada exitosamente");
        return new ModelAndView("redirect:/admin/imagenes/");
    }

    @GetMapping("/eliminar/{imagenId}")
    public ModelAndView eliminarImagen(@PathVariable Long imagenId, RedirectAttributes redirectAttrs, @RequestHeader("referer") String referer){
        imagenRepository.deleteById(imagenId);
        redirectAttrs.addFlashAttribute("mensaje","Imagen eliminada exitosamente");
        return new ModelAndView("redirect:" + referer);
    }

}
