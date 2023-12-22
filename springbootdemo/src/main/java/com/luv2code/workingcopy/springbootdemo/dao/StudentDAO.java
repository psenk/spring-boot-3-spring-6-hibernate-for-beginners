package com.luv2code.workingcopy.springbootdemo.dao;

import java.util.List;

import com.luv2code.workingcopy.springbootdemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);
}
