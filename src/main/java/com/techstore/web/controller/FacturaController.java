package com.techstore.web.controller;

import com.techstore.web.dao.FacturaRepository;
import com.techstore.web.dao.OrdenRepository;
import com.techstore.web.dao.TipoPagoRepository;
import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.Factura;
import com.techstore.web.model.Orden;
import com.techstore.web.model.Usuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Log4j2
public class FacturaController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    TipoPagoRepository tipoPagoRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @GetMapping("/facturar")
    public ModelAndView facturar(ModelMap model){
        // Tomar TODO usuario actual de Spring Security
        Usuario usuario = usuarioRepository.findByNombreUsuario("test");
        Orden orden = ordenRepository.getOrdenActiva(usuario.getNombreUsuario());
        model.addAttribute("orden", orden);
        model.addAttribute("listaTipoPago", tipoPagoRepository.findAll());
        return new ModelAndView("index", model);
    }

    @GetMapping("/misordenes")
    public ModelAndView listarHistorialFacturas(ModelMap model){
        model.addAttribute("titulo", "Mis ordenes");
        // TODO Tomar usuario actual de Spring Security
        Usuario usuario = usuarioRepository.findByNombreUsuario("test");
        List<Factura> listaFacturas = facturaRepository.findByOrdenUsuarioNombreUsuarioOrderByFecha(usuario.getNombreUsuario());
        model.addAttribute("listaFacturas", listaFacturas);
        return new ModelAndView("facturas/listar-facturas", model);
    }


}
