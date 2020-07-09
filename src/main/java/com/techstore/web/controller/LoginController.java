package com.techstore.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping("/")
    public ModelAndView showLandingPage(){
        return new ModelAndView("index");
    }

}
