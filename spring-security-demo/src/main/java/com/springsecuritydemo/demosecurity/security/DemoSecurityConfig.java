package com.springsecuritydemo.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // JDBC support
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // for use with custom user/roles tables in database
        // define query to retrieve user by user name
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id = ?");

        // define query to retrieve authorities by user name
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id = ?");

        return jdbcUserDetailsManager;
    }

    // filter incoming http requests
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // custom login forms require custom error messages
        // authorize all authenticated requests
        http.authorizeHttpRequests(configurer -> configurer
                // if requester has role proper role
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/systems/**").hasRole("ADMIN")
                .anyRequest().authenticated())
                // add spring security login support
                .formLogin(form -> form.loginPage("/loginPage")
                        .loginProcessingUrl("/authenticateTheUser").permitAll())
                // adds spring security logout support
                .logout(logout -> logout.permitAll())
                // custom error page
                .exceptionHandling(configurer -> configurer
                        .accessDeniedPage("/access-denied"));

        return http.build();
    }

    /*
     * @Bean
     * public InMemoryUserDetailsManager userDetailsManager() {
     * 
     * UserDetails john =
     * User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").
     * build();
     * UserDetails mary =
     * User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE",
     * "MANAGER")
     * .build();
     * UserDetails susan =
     * User.builder().username("susan").password("{noop}test123")
     * .roles("EMPLOYEE", "MANAGER", "ADMIN").build();
     * 
     * return new InMemoryUserDetailsManager(john, mary, susan);
     * }
     */

}
