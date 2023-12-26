package com.luv2code.workingcopy.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.workingcopy.springbootdemo.entity.Employee;


// does all DAO CRUD methods automatically for free
//@RepositoryRestResource(path = "members") // custon URL path /members
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
