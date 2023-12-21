package com.luv2code.workingcopy.springbootdemo.common;

// 3rd party software (not a component)
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

	@Override
	public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

}
