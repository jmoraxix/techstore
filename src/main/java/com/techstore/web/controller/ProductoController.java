package com.techstore.web.controller;


import com.techstore.web.dao.MarcaRepository;
import com.techstore.web.dao.ProductoRepository;


import com.techstore.web.dao.TipoProductoRepository;
import com.techstore.web.model.Producto;
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
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private MarcaRepository marcaRepository;


    @GetMapping("/")
    public ModelAndView listarProductos(ModelMap model) {
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("listaProductos", listaProductos);
        return new ModelAndView("productos/listar-productos", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearProducto(ModelMap model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaTipoProducto", tipoProductoRepository.findAll());
        model.addAttribute("listaMarcas", marcaRepository.findAll());
        return new ModelAndView("productos/editar-producto", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, RedirectAttributes redirectAttrs) {
        productoRepository.save(producto);
        redirectAttrs.addFlashAttribute("mensaje", "Nuevo producto creado");
        return new ModelAndView("redirect:/productos/");
    }

    @GetMapping("/{productoId}")
    public ModelAndView mostrarProducto(@PathVariable Long productoId, ModelMap model) {
        Optional<Producto> producto = productoRepository.findById(productoId);
        model.addAttribute("producto", producto.get());
        return new ModelAndView("productos/ver-producto", model);
    }

    @GetMapping("/editar/{productoId}")
    public ModelAndView editarProducto(@PathVariable Long productoId, ModelMap model) {
        Optional<Producto> producto = productoRepository.findById(productoId);
        model.addAttribute("producto", producto.get());
        model.addAttribute("listaTipoProducto", tipoProductoRepository.findAll());
        model.addAttribute("listaMarcas", marcaRepository.findAll());
        return new ModelAndView("productos/editar-producto", model);
    }

    @PostMapping("/editar/{productoId}")
    public ModelAndView updateProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, RedirectAttributes redirectAttrs) {
        productoRepository.save(producto);
        redirectAttrs.addFlashAttribute("mensaje", "Producto actualizado exitosamente");
        return new ModelAndView("redirect:/productos/");
    }

    @GetMapping("/eliminar/{productoId}")
    public ModelAndView deleteProducto(@PathVariable Long productoId, RedirectAttributes redirectAttrs) {
        productoRepository.deleteById(productoId);
        redirectAttrs.addFlashAttribute("mensaje", "Producto eliminado exitosamente");
        return new ModelAndView("redirect:/productos/");
    }

}

