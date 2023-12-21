package com.luv2code.workingcopy.springbootdemo.common;

//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;

@Component
// prototype scope: each new instance is a new bean.
// default scope: singleton (only one bean of this type exists)
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	// POST CONSTRUCT - this code runs first before the bean is created
/* 	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
	}

	// PRE DESTROY - this code runs right before the bean is destroyed
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
	} */


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes!!!!";
	}
	
}