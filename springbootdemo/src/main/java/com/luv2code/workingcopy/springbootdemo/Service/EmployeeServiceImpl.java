package com.luv2code.workingcopy.springbootdemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.workingcopy.springbootdemo.dao.EmployeeDAO;
import com.luv2code.workingcopy.springbootdemo.entity.Employee;

import jakarta.transaction.Transactional;

// SERVICE - allows us to use multiple DAOs to get data from many different dbs
// put @Transactional here instead of DAO (best practice)
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
        
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }

}
