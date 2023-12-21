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
    //private Coach anotherCoach;

    // no args constructor
    public DemoController() {
    }

    // CONSTRUCTOR INJECTION
    @Autowired
    // define constructor for DI
    public DemoController(@Qualifier("aquatic") Coach theCoach/*,
            @Qualifier("cricketCoach") Coach theAnotherCoach*/) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        //anotherCoach = theAnotherCoach;
    }

    // SETTER INJECTION
    /*
     * @Autowired
     * public void setCoach(/*@Qualifier("cricketCoach") Coach theCoach) {
     * myCoach = theCoach;
     * }
     */

    // directing to /dailyworkout URL
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // Scope practice
/*     @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    } */
}
