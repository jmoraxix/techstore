package com.techstore.web.controller;

import com.techstore.web.model.Orden;
import com.techstore.web.service.OrdenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@RestController
@Log4j2
@RequestMapping("/carrito")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public ModelAndView listarOrdenes(ModelMap model){
        Orden orden = ordenService.getCurrentOrden();
        model.addAttribute("orden", orden);
        return new ModelAndView("carrito/listar-orden", model);
    }

    @GetMapping("/{productoId}")
    @Transactional
    public ModelAndView agregarProductoOrden(@PathVariable Long productoId, @RequestHeader("referer") String referer, RedirectAttributes redirectAttrs){
        ordenService.agregarProductoOrden(productoId);
        redirectAttrs.addFlashAttribute("mensaje", "Producto agregado al carrito");
        return new ModelAndView("redirect:" + referer);
    }

    @GetMapping("/eliminar/{itemOrdenId}")
    @Transactional
    public ModelAndView eliminarProductoOrden(@PathVariable Long itemOrdenId, RedirectAttributes redirectAttrs){
        ordenService.eliminarProductoOrden(itemOrdenId);
        redirectAttrs.addFlashAttribute("mensaje", "Producto eliminado del carrito");
        return new ModelAndView("redirect:/carrito");
    }
}
