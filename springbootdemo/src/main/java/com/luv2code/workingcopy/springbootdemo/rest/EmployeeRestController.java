package com.luv2code.workingcopy.springbootdemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.workingcopy.springbootdemo.Service.EmployeeService;
import com.luv2code.workingcopy.springbootdemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController() {
    }

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET HTTP REQUEST
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // GET HTTP REQUEST
    @GetMapping("/employees/{employeeId}")
    public Employee findbyId(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    // POST HTTP REQUEST
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // PUT HTTP REQUEST
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // DELETE HTTP REQUEST
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
