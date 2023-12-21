package com.luv2code.workingcopy.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.workingcopy.springbootdemo.common.Coach;

@RestController
public class DemoController {

    // QUALIFIER ANNOTATION - used when you have many classes implementing the
    // dependency (aka many Coache implementations, hockeyCoach, tennisCoach,
    // baseballCoach, etc.)

    // define private field for dependency
    private Coach myCoach;

    // no args constructor
    public DemoController() {
    }

    // CONSTRUCTOR INJECTION
    @Autowired
    // define constructor for DI
    public DemoController(/*@Qualifier("baseballCoach")*/ Coach theCoach) {
        myCoach = theCoach;
    }

    // SETTER INJECTION
    @Autowired
    public void setCoach(/*@Qualifier("cricketCoach")*/ Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
