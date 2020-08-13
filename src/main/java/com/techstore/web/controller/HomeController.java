package com.techstore.web.controller;

import com.techstore.web.dao.CategoriaRepository;
import com.techstore.web.dao.ProductoRepository;
import com.techstore.web.dao.TipoProductoRepository;
import com.techstore.web.model.Categoria;
import com.techstore.web.model.Producto;
import com.techstore.web.model.TipoProducto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ModelAndView cargarHome(ModelMap model) {
        model.addAttribute("listaMenu", categoriaRepository.findAll());
        model.addAttribute("listaProductos", productoRepository.findAll());
        return new ModelAndView("home/home", model);
    }

    @GetMapping("/{categoriaId}")
    public ModelAndView mostrarTipoProducto(@PathVariable Long categoriaId, ModelMap model) {
        Categoria categoria = categoriaRepository.findById(categoriaId).get();
        List<TipoProducto> listaTipoProductos = tipoProductoRepository.getTipoProductByCategoria(categoria);

        model.addAttribute("categoriaSeleccionada", categoria.getId());
        model.addAttribute("listaMenu", categoriaRepository.findAll());
        model.addAttribute("listaProductos", productoRepository.getAllFromListaTipoProductos(listaTipoProductos));
        return new ModelAndView("home/home", model);
    }

    @GetMapping("/{categoriaId}/{tipProductoId}")
    public ModelAndView mostrarProducto(@PathVariable Long categoriaId, @PathVariable Long tipProductoId, ModelMap model) {
        Categoria categoria = categoriaRepository.findById(categoriaId).get();
        TipoProducto tipoProducto = tipoProductoRepository.findById(tipProductoId).get();
        List<Producto> productos = productoRepository.getAllFromTipoProductos(tipoProducto);

        model.addAttribute("categoriaSeleccionada", categoria.getId());
        model.addAttribute("tipoProductoSeleccionado", tipoProducto.getId());
        model.addAttribute("listaMenu", categoriaRepository.findAll());
        model.addAttribute("listaProductos", productos);
        return new ModelAndView("home/home", model);
    }
}
