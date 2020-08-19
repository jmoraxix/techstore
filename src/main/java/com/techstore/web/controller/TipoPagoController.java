package com.techstore.web.controller;

import com.techstore.web.dao.TipoPagoRepository;
import com.techstore.web.model.TipoPago;
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
@RequestMapping("/admin/tipopago")
public class TipoPagoController {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @GetMapping("/")
    public ModelAndView listarTipoPago(ModelMap model){
        List<TipoPago> listaTipoPago = tipoPagoRepository.findAll();
        model.addAttribute("listaTipoPago", listaTipoPago);
        return new ModelAndView("tipopago/listar-tipo-pago", model);
    }

    @GetMapping("/crear")
    public ModelAndView crearTipoPago(ModelMap model){
        model.addAttribute("tipoPago", new TipoPago());
        model.addAttribute("modo", "crear");
        return new ModelAndView("tipopago/editar-tipo-pago", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView guardarNuevoTipoPago(@Valid @ModelAttribute("tipoPago") TipoPago tipoPago, BindingResult result, RedirectAttributes redirectAttrs) {
        tipoPagoRepository.save(tipoPago);
        redirectAttrs.addFlashAttribute("mensaje", "Nuevo Tipo de Pago creado");
        return new ModelAndView("redirect:/admin/tipopago/");
    }

    @GetMapping("/{tipoPagoId}")
    public ModelAndView mostrarTipoPago(@PathVariable Long tipoPagoId, ModelMap model){
        Optional<TipoPago> tipoPago = tipoPagoRepository.findById(tipoPagoId);
        model.addAttribute("tipoPago", tipoPago.get());
        return new ModelAndView("tipopago/ver-tipo-pago", model);
    }

    @GetMapping("/editar/{tipoPagoId}")
    public ModelAndView editarTipoPago(@PathVariable Long tipoPagoId, ModelMap model){
        Optional<TipoPago> tipoPago = tipoPagoRepository.findById(tipoPagoId);
        model.addAttribute("tipoPago", tipoPago.get());
        model.addAttribute("modo", "editar");
        return new ModelAndView("tipopago/editar-tipo-pago", model);
    }

    @PostMapping(value = "/editar/{tipoPagoId}")
    public ModelAndView guardarEditarTipoPago(@Valid @ModelAttribute("tipoPago") TipoPago tipoPago, BindingResult result, RedirectAttributes redirectAttrs) {
        tipoPagoRepository.save(tipoPago);
        redirectAttrs.addFlashAttribute("mensaje", "Tipo de Pago actualizado exitosamente");
        return new ModelAndView("redirect:/admin/tipopago/");
    }

    @GetMapping("/eliminar/{tipoPagoId}")
    public ModelAndView eliminarTipoPago(@PathVariable Long tipoPagoId, RedirectAttributes redirectAttrs){
        tipoPagoRepository.deleteById(tipoPagoId);
        redirectAttrs.addFlashAttribute("mensaje", "Tipo de Pago eliminado exitosamente");
        return new ModelAndView("redirect:/admin/tipopago/");
    }
}
