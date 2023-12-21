package com.luv2code.workingcopy.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.workingcopy.springbootdemo.dao.StudentDAO;
import com.luv2code.workingcopy.springbootdemo.entity.Student;

// EXPLICIT LISTING OF COMPONENT PACKAGES TO SCAN EXAMPLE:
//@SpringBootApplication(scanBasePackages=({"com.luv2code.otherpackage", "org.acme.packagetwo"})

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	// creating a bean command line runner, commands that are run after beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// lambda function
		return runner -> 
		createStudent(studentDAO);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student
		System.out.println("Created new student...");
		Student tempStudent = new Student("Paul", "Doe", "paul@email.com");

		// save student
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student.  Generated id: " + tempStudent.getId());
	}

}
