package home.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

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

    // method to read form data
    // add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read request from html form
        String name = request.getParameter("studentName");

        // convert to uppercase
        name = name.toUpperCase();

        // create message
        String result = "Yo! " + name;

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
        name = name.toUpperCase();
        String result = "Hey my Friend from v3! " + name;
        model.addAttribute("message", result);
        return "helloworld";
    }
    
}
