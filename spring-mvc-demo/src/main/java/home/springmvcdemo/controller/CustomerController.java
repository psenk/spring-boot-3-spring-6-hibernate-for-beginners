package home.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import home.springmvcdemo.model.Customer;
import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    // @Valid tells Spring to validate the data in customer object on the model
    // BindingResult stores the results of the above validation (if data passed validation or not)
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        
        if (result.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }

}
