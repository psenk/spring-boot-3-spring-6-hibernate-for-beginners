package com.luv2code.workingcopy.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// EXPLICIT LISTING OF COMPONENT PACKAGES TO SCAN EXAMPLE:
//@SpringBootApplication(scanBasePackages=({"com.luv2code.otherpackage", "org.acme.packagetwo"})

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	// creating a bean command line runner, commands that are run after beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> System.out.println("Hello World");
	}
}
