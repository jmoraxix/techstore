package com.techstore.web.controller;

import com.techstore.web.dao.SucursalRepository;
import com.techstore.web.model.RolUsuario;
import com.techstore.web.model.Sucursal;
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
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private  SucursalRepository sucursalRepository;

    @GetMapping("/")
    public ModelAndView listarSucursales(ModelMap model){
        List<Sucursal> listaSucursales = sucursalRepository.findAll();
        model.addAttribute("listaSucursales", listaSucursales);
        return new ModelAndView("sucursal/listar-sucursales", model);
    }
    @GetMapping("/crear")
    public ModelAndView crearSucursal(ModelMap model){
        model.addAttribute("sucursal", new Sucursal());
        return new ModelAndView("sucursal/editar-sucursales", model);
    }

    @PostMapping(value = "/crear")
    public ModelAndView crearsucursal(@Valid @ModelAttribute("codigo") Sucursal sucursal, BindingResult result, RedirectAttributes redirectAttrs){
        sucursalRepository.save(sucursal);
        redirectAttrs.addFlashAttribute("mensaje", "Sucursal creada exitosamente");
        return new ModelAndView("redirect:/sucursal/");
    }

    @GetMapping("/editar/{SucursalId}")
    public ModelAndView editarSucursal(@PathVariable Long SucursalId, ModelMap model){
        Optional<Sucursal> sucursales = sucursalRepository.findById(SucursalId);
        model.addAttribute("sucursal", sucursales.get());
        return new ModelAndView("sucursal/editar-sucursales", model);
    }

    @PostMapping(value = "/editar/{SucursalId}")
    public ModelAndView guardarSucursal(@Valid @ModelAttribute("codigo") Sucursal sucursales, BindingResult result, RedirectAttributes redirectAttrs){
        sucursalRepository.save(sucursales);
        redirectAttrs.addFlashAttribute("mensaje", "Sucursal actualizada exitosamente");
        return new ModelAndView("redirect:/sucursal/");
    }

    @GetMapping("/{codigo}")
    public ModelAndView mostrarSucursal(@PathVariable Long codigo, ModelMap model){
        Optional<Sucursal> sucursales = sucursalRepository.findById(codigo);
        model.addAttribute("sucursal", sucursales.get());
        return new ModelAndView("sucursal/ver-sucursal", model);
    }

    @GetMapping("/eliminar/{SucursalId}")
    public ModelAndView deleteTipoPago(@PathVariable Long SucursalId, RedirectAttributes redirectAttrs){
        sucursalRepository.deleteById(SucursalId);
        redirectAttrs.addFlashAttribute("mensaje", "Sucursal eliminada exitosamente");
        return new ModelAndView("redirect:/sucursal/");
    }





}
