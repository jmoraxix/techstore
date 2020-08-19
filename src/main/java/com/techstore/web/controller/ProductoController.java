package com.techstore.web.controller;

import com.techstore.web.dao.ImagenRepository;
import com.techstore.web.dao.MarcaRepository;
import com.techstore.web.dao.ProductoRepository;
import com.techstore.web.dao.TipoProductoRepository;
import com.techstore.web.model.Imagen;
import com.techstore.web.model.Producto;
import com.techstore.web.storage.StorageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/admin/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ImagenRepository imagenRepository;


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
        model.addAttribute("modo", "crear");
        return new ModelAndView("productos/editar-producto", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, RedirectAttributes redirectAttrs) {
        productoRepository.save(producto);
        redirectAttrs.addFlashAttribute("mensaje", "Nuevo producto creado");
        return new ModelAndView("redirect:/admin/productos/");
    }

    @GetMapping("/{productoId}")
    public ModelAndView mostrarProducto(@PathVariable Long productoId, ModelMap model) {
        Producto producto = productoRepository.findById(productoId).get();
        model.addAttribute("producto", producto);
        return new ModelAndView("productos/ver-producto", model);
    }

    @GetMapping("/editar/{productoId}")
    public ModelAndView editarProducto(@PathVariable Long productoId, ModelMap model) {
        Producto producto = productoRepository.findById(productoId).get();
        model.addAttribute("producto", producto);
        model.addAttribute("listaTipoProducto", tipoProductoRepository.findAll());
        model.addAttribute("listaMarcas", marcaRepository.findAll());
        model.addAttribute("modo", "editar");
        return new ModelAndView("productos/editar-producto", model);
    }

    @PostMapping("/editar/{productoId}")
    public ModelAndView updateProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, RedirectAttributes redirectAttrs) {
        productoRepository.save(producto);
        redirectAttrs.addFlashAttribute("mensaje", "Producto actualizado exitosamente");
        return new ModelAndView("redirect:/admin/productos/");
    }

    @GetMapping("/eliminar/{productoId}")
    public ModelAndView deleteProducto(@PathVariable Long productoId, RedirectAttributes redirectAttrs) {
        productoRepository.deleteById(productoId);
        redirectAttrs.addFlashAttribute("mensaje", "Producto eliminado exitosamente");
        return new ModelAndView("redirect:/admin/productos/");
    }

    /* SUBIR IMAGEN */
    @GetMapping("/{productoId}/imagenes")
    public ModelAndView listarProductoImagenes(@PathVariable Long productoId, Model model, @RequestHeader("referer") String referer) throws IOException {
        Producto producto = productoRepository.findById(productoId).get();
        model.addAttribute("producto", producto);
        return new ModelAndView("productos/producto-imagen");
    }

    @PostMapping("/{productoId}/imagenes/agregar")
    @Transactional
    public ModelAndView agregarProductoImagen(@PathVariable Long productoId, @RequestParam("imagen") MultipartFile nuevaImagen, RedirectAttributes redirectAttrs) {
        Producto producto = productoRepository.findById(productoId).get();

        storageService.store(nuevaImagen); // Guarda el archivo de la nueva imagen
        Imagen imagen = new Imagen();
        imagen.setProducto(producto);
        imagen.setNombre(nuevaImagen.getOriginalFilename());
        imagenRepository.save(imagen); //Crea una nueva imagen

        redirectAttrs.addFlashAttribute("mensaje", "Imagen del producto " + producto.getNombre() + " agregada exitosamente");
        return new ModelAndView("redirect:/admin/productos/" + producto.getId() + "/imagenes/");
    }
}

