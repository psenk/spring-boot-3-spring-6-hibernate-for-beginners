package com.luv2code.workingcopy.springbootdemo.Service;

import java.util.List;

import com.luv2code.workingcopy.springbootdemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
