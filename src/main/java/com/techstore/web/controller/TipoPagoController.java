package com.techstore.web.controller;

import com.techstore.web.dao.TipoPagoRepository;
import com.techstore.web.model.TipoPago;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@Log4j2
@RequestMapping("/tipopago")
public class TipoPagoController {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @GetMapping("/")
    public ModelAndView listarTipoPago(ModelMap model){
        List<TipoPago> listaTipoPago = tipoPagoRepository.findAll();
        model.addAttribute("listaTipoPago", listaTipoPago);
        return new ModelAndView("tipopago/listar-tipo-pago", model);
    }
}
