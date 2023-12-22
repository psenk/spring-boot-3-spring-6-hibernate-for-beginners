package com.luv2code.workingcopy.springbootdemo;

import java.util.List;

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
		//createStudent(studentDAO);
		//createMultipleStudents(studentDAO);
		//readStudent(studentDAO);
		//queryForStudents(studentDAO);
		queryForStudentsByLastName(studentDAO);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Carpenter");

		for (Student s : theStudents) {
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student s : theStudents) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student
		Student tempStudent = new Student("Kyle", "Beaver", "fakeemail@email.com");

		// save student
		studentDAO.save(tempStudent);
		
		// display student id
		int theID = tempStudent.getId();
		System.out.println("Student ID number: " + theID);

		// retrieve student based on id
		tempStudent = studentDAO.findById(theID);

		// display student
		System.out.println(tempStudent.toString());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create students
		Student tempStudent1 = new Student("John", "Carpenter", "john@email.com");
		Student tempStudent2 = new Student("Jane", "Bless", "jane@email.com");
		Student tempStudent3 = new Student("Benita", "Applebaum", "benita@email.com");

		// save students
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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
