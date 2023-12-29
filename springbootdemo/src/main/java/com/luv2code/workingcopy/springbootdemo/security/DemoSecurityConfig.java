package com.luv2code.workingcopy.springbootdemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// {xxxx} before a password = specify encryption (noop, bcrypt, etc)

@Configuration
public class DemoSecurityConfig {

    // JDBC support, connects to db specified in application.properties
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // two custom methods REQUIRED if using custom tables w/ jdbc
        // define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");

        // define query to retrieve the roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;
    }

    // filter http method requests based on end point and roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        // use basic http authentication
        http.httpBasic(Customizer.withDefaults());

        // disable "cross site request forgery"
        // not required for stateless REST APIs
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    // hard coded users in memory for testing
    /*
     * @Bean
     * public InMemoryUserDetailsManager userDetailsManager() {
     * 
     * UserDetails john = User.builder()
     * .username("john")
     * .password("{noop}test123")
     * .roles("EMPLOYEE")
     * .build();
     * 
     * UserDetails mary = User.builder()
     * .username("mary")
     * .password("{noop}test123")
     * .roles("EMPLOYEE", "MANAGER")
     * .build();
     * 
     * UserDetails susan = User.builder()
     * .username("susan")
     * .password("{noop}test123")
     * .roles("EMPLOYEE", "MANAGER", "ADMIN")
     * .build();
     * 
     * return new InMemoryUserDetailsManager(john, mary, susan);
     * }
     */

}
