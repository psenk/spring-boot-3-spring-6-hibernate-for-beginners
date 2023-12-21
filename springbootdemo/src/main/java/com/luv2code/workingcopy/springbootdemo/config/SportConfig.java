package com.luv2code.workingcopy.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.workingcopy.springbootdemo.common.Coach;
import com.luv2code.workingcopy.springbootdemo.common.SwimCoach;

// creating a custom spring bean using 3rd party code (SwimCoach object)
@Configuration
public class SportConfig {

    // creating the bean
    @Bean("aquatic") // custom bean name
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
