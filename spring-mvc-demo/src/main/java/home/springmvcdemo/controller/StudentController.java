package home.springmvcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import home.springmvcdemo.model.Student;

@Controller
public class StudentController {

    // fields
    // importing value from the application.properties file
    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create new student object
        Student newStudent = new Student();

        // add student to model as attribute
        model.addAttribute("student", newStudent);

        model.addAttribute("countries", countries);

        return "student-form";

    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {

        // logging input data
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";

    }

}
