package com.luv2code.workingcopy.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" (root), say Hello World

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
}
