package com.luv2code.workingcopy.springbootdemo.common;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// PRIMARY ANNOTATION - this bean will be selected first of any other class implementing something similar
//@Primary
public class TennisCoach implements Coach {

	public TennisCoach() {
		//System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley.";
	}

}
