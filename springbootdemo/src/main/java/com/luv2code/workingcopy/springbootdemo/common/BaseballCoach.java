package com.luv2code.workingcopy.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}

}
