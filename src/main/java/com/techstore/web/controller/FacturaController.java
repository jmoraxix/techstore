package com.techstore.web.controller;

import com.techstore.web.model.Factura;
import com.techstore.web.service.FacturaService;
import com.techstore.web.service.OrdenService;
import com.techstore.web.service.TipoPagoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class FacturaController {

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private TipoPagoService tipoPagoService;

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturar")
    public ModelAndView prepararFactura(ModelMap model){
        Factura factura = new Factura();
        factura.setOrden(ordenService.getCurrentOrden());
        model.addAttribute("factura", factura);
        model.addAttribute("listaTipoPago", tipoPagoService.findAll());
        return new ModelAndView("facturas/facturar", model);
    }

    @Transactional
    @PostMapping("/facturar")
    public ModelAndView facturar(@Valid @ModelAttribute("factura") Factura factura, BindingResult result, RedirectAttributes redirectAttrs){
        factura.facturar();
        ordenService.actualizarOrden(factura.getOrden());
        facturaService.facturar(factura);
        redirectAttrs.addFlashAttribute("mensaje", "Se ha facturado correctamente.");
        return new ModelAndView("redirect:/ordenes");
    }

    @GetMapping("/ordenes")
    public ModelAndView listarHistorialFacturas(ModelMap model){
        List<Factura> listaFacturas = facturaService.getListaFacturas();
        if(listaFacturas == null){
            listaFacturas = new ArrayList<Factura>();
        }
        model.addAttribute("listaFacturas", listaFacturas);
        return new ModelAndView("facturas/listar-facturas", model);
    }

    @GetMapping("/ordenes/{facturaId}")
    public ModelAndView mostrarFacturar(@PathVariable Long facturaId, ModelMap model){
        model.addAttribute("factura", facturaService.findById(facturaId));
        return new ModelAndView("facturas/mostrar-factura", model);
    }


}
