package com.techstore.web.controller;

import com.techstore.web.dao.CategoriaRepository;
import com.techstore.web.dao.TipoProductoRepository;
import com.techstore.web.model.TipoProducto;
import com.techstore.web.service.CategoriaService;
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
@RequestMapping("/admin/tipoproducto")
public class TipoProductoController {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ModelAndView listarTipoProducto(ModelMap model) {
        List<TipoProducto> listaTipoProducto = tipoProductoRepository.findAll();
        model.addAttribute("listaTipoProducto", listaTipoProducto);
        return new ModelAndView("tipoproducto/listar-tipo-producto", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearTipoProducto(ModelMap model) {
        model.addAttribute("tipoProducto", new TipoProducto());
        model.addAttribute("listaCategorias", categoriaService.findAllOrdered());
        model.addAttribute("modo", "crear");
        return new ModelAndView("tipoproducto/editar-tipo-producto" ,model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarNuevoTipoProducto(@Valid @ModelAttribute("tipoProducto") TipoProducto tipoProducto, BindingResult result, RedirectAttributes redirectAttrs) {
        tipoProductoRepository.save(tipoProducto);
        redirectAttrs.addFlashAttribute("mensaje", "Nuevo Tipo de Producto creado");
        return new ModelAndView("redirect:/admin/tipoproducto/");
    }

    @GetMapping("/{tipoProductoId}")
    public ModelAndView mostrarTipoProducto(@PathVariable Long tipoProductoId, ModelMap model){
        Optional<TipoProducto> tipoProducto = tipoProductoRepository.findById(tipoProductoId);
        model.addAttribute("tipoProducto", tipoProducto.get());
        return new ModelAndView("tipoproducto/ver-tipo-producto", model);
    }

    @GetMapping("/editar/{tipoProductoId}")
    public ModelAndView editarTipoProducto(@PathVariable Long tipoProductoId, ModelMap model){
        Optional<TipoProducto> tipoProducto = tipoProductoRepository.findById(tipoProductoId);
        model.addAttribute("tipoProducto", tipoProducto.get());
        model.addAttribute("listaCategorias", categoriaRepository.findAll());
        model.addAttribute("modo", "editar");
        return new ModelAndView("tipoproducto/editar-tipo-producto", model);
    }

    @PostMapping(value = "/editar/{tipoProductoId}")
    public ModelAndView guardarEditarTipoProductoId(@Valid @ModelAttribute("tipoProducto") TipoProducto tipoProducto, BindingResult result, RedirectAttributes redirectAttrs) {
        tipoProductoRepository.save(tipoProducto);
        redirectAttrs.addFlashAttribute("mensaje", "Tipo de Producto actualizado exitosamente");
        return new ModelAndView("redirect:/admin/tipoproducto/");
    }

    @GetMapping("/eliminar/{tipoProductoId}")
    public ModelAndView eliminarTipoProducto(@PathVariable Long tipoProductoId, RedirectAttributes redirectAttrs){
        tipoProductoRepository.deleteById(tipoProductoId);
        redirectAttrs.addFlashAttribute("mensaje", "Tipo de Producto eliminado exitosamente");
        return new ModelAndView("redirect:/admin/tipoproducto/");
    }
}














