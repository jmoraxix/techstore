package com.techstore.web.controller;


import com.techstore.web.dao.InventarioRepository;
import com.techstore.web.dao.ProductoRepository;
import com.techstore.web.dao.SucursalRepository;
import com.techstore.web.model.Inventario;
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
@RequestMapping("/admin/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/")
    public ModelAndView listarInventario(ModelMap model){
        List<Inventario> listaInventario = inventarioRepository.findAll();
        model.addAttribute("listaInventario", listaInventario);
        return new ModelAndView("inventario/listar-inventario", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearInventario(ModelMap model){
        model.addAttribute("inventario", new Inventario());
        model.addAttribute("listaSucursales", sucursalRepository.findAll());
        model.addAttribute("listaProductos", productoRepository.findAll());
        model.addAttribute("modo", "crear");
        return new ModelAndView("inventario/editar-inventario" ,model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarNuevoInventario(@Valid @ModelAttribute("inventario") Inventario inventario, BindingResult result, RedirectAttributes redirectAttrs) {
        inventarioRepository.save(inventario);
        redirectAttrs.addFlashAttribute("mensaje", "Nuevo Articulo agregado al Inventario");
        return new ModelAndView("redirect:/admin/inventario/");
    }

    @GetMapping("/{inventarioId}")
    public ModelAndView mostrarInventario(@PathVariable Long inventarioId, ModelMap model){
        Optional<Inventario> inventario = inventarioRepository.findById(inventarioId);
        model.addAttribute("inventario", inventario.get());
        return new ModelAndView("inventario/ver-inventario", model);
    }

    @GetMapping("/editar/{inventarioId}")
    public ModelAndView editarInventario(@PathVariable Long inventarioId, ModelMap model){
        Optional<Inventario> inventario = inventarioRepository.findById(inventarioId);
        model.addAttribute("inventario", inventario.get());
        model.addAttribute("listaSucursales", sucursalRepository.findAll());
        model.addAttribute("listaProductos", productoRepository.findAll());
        model.addAttribute("modo", "editar");
        return new ModelAndView("inventario/editar-inventario", model);
    }

    @PostMapping(value = "/editar/{inventarioId}")
    public ModelAndView guardarEditarInventarioId(@Valid @ModelAttribute("inventario") Inventario inventario, BindingResult result, RedirectAttributes redirectAttrs) {
        inventarioRepository.save(inventario);
        redirectAttrs.addFlashAttribute("mensaje", "Inventario actualizado exitosamente");
        return new ModelAndView("redirect:/admin/inventario/");
    }

    @GetMapping("/eliminar/{inventarioId}")
    public ModelAndView eliminarInventario(@PathVariable Long inventarioId, RedirectAttributes redirectAttrs){
        inventarioRepository.deleteById(inventarioId);
        redirectAttrs.addFlashAttribute("mensaje", "Inventario eliminado exitosamente");
        return new ModelAndView("redirect:/inventario/");
    }
}














