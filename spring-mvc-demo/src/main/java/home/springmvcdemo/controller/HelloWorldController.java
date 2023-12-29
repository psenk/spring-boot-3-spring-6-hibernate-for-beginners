package home.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // method to show form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // method to process form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

}
