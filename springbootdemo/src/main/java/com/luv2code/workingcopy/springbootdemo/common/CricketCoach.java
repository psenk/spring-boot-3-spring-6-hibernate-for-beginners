package com.luv2code.workingcopy.springbootdemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// prototype scope: each new instance is a new object.
// default scope: singleton (only one object of this type exists)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes!!!!";
	}
	
}