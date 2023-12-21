package com.luv2code.workingcopy.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.workingcopy.springbootdemo.Coach;

@RestController
public class DemoController {

    // define private field for dependency
    private Coach myCoach;

    public DemoController() {
	}

	@Autowired
    // define constructor for DI
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
