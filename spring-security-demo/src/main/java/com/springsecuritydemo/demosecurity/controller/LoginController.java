package com.springsecuritydemo.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/loginPage")
    public String loginPage(Model model) {
        //return "plain-login";
        return "fancy-login";
    }

}
