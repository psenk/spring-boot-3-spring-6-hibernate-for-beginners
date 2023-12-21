package com.luv2code.workingcopy.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// EXPLICIT LISTING OF COMPONENT PACKAGES TO SCAN EXAMPLE:
//@SpringBootApplication(scanBasePackages=({"com.luv2code.otherpackage", "org.acme.packagetwo"})

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
