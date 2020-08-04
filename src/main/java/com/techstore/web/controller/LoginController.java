package com.techstore.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Log4j2
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public ModelAndView mostrarLogin(ModelMap model) {
        return new ModelAndView("login/iniciar-sesion", model);
    }
}
