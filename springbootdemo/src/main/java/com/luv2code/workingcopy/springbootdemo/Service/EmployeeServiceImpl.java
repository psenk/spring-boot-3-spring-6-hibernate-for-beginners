/* package com.luv2code.workingcopy.springbootdemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.workingcopy.springbootdemo.dao.EmployeeRespository;
import com.luv2code.workingcopy.springbootdemo.entity.Employee;

// SERVICE - allows us to use multiple DAOs to get data from many different dbs
// put @Transactional here instead of DAO (best practice)
@Service
public class EmployeeServiceImpl implements EmployeeService {

    //private EmployeeDAO employeeDAO;
    private EmployeeRespository employeeRespository;

    public EmployeeServiceImpl() {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRespository.findById(theId);
        
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
        
    }

    @Override
    //@Transactional
    public Employee save(Employee theEmployee) {
        return employeeRespository.save(theEmployee);
    }

    @Override
    //@Transactional
    public void deleteById(int theId) {
        employeeRespository.deleteById(theId);
    }

}
 */