package com.luv2code.workingcopy.springbootdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.workingcopy.springbootdemo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Tyler", "Senk"));
        theStudents.add(new Student("Amy", "Fowler"));
        theStudents.add(new Student("Sheldon", "Cooper"));
    }

    // add code for "/students" endpoint
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

}
