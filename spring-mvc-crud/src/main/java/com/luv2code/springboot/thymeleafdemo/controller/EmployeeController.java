package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // showing employee directory, default view
    @GetMapping("/list")
    public String listEmployees(Model model) {
        
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    // getting the form to add a new employee to the database
    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model) {
        
        Employee newEmployee = new Employee();

        model.addAttribute("employee", newEmployee);

        return "employees/employee-form";
    }

    // saving the new employee to the database
    @PostMapping("/save")
    // getting the employee from the model to save
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    // getting employee from the database for updating, by id number
    @GetMapping("/updateEmployeeForm")
    public String updateEmployeeForm(@RequestParam("employeeId") int id, Model model) {

        // adding the employee to the model for form access
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    // deleting employee from the database, by id number
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
