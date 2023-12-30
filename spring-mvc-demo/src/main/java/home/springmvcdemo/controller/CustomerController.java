package home.springmvcdemo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import home.springmvcdemo.model.Customer;
import jakarta.validation.Valid;

@Controller
public class CustomerController {

    // INIT BINDER - this is done to the data before it is mapped
    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {

        // trims leading and trailing whitespace
        // returns null if all whitespace
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    // @Valid tells Spring to validate the data in customer object on the model
    // BindingResult stores the results of the above validation (if data passed validation or not)
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        
        System.out.println("Last name: |" + customer.getLastName() + "|");

        System.out.println("Binding results: " + result.toString());

        System.out.println();

        if (result.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }

}
