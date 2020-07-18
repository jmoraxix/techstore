package com.techstore.web.controller;
import com.techstore.web.dao.SucursalRepository;
import com.techstore.web.model.Sucursal;
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
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private  SucursalRepository sucursalRepository;

    @GetMapping("/")
    public ModelAndView listarSucursales(ModelMap model){
        List<Sucursal> listaSucursales = sucursalRepository.findAll();
        model.addAttribute("listaSucursales", listaSucursales);
        return new ModelAndView("Sucursal/listarSucursales", model);
    }
}
