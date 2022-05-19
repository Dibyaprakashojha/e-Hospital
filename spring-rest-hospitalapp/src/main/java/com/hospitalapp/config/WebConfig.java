package com.hospitalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    // authentication using jpa

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable() // disable the csrf attack
                .authorizeRequests()
                .antMatchers("/admin/**")
                    .hasRole("ADMIN") // permit this url to Admin only
                .antMatchers("/doctor/**")
                    .hasRole("DOCTOR")
                .antMatchers("/appointment-api/appointments","/appointment-api/appointmentsdelete-appointment/**")
                    .hasRole("USER")
                .antMatchers("/register")
                    .permitAll()
                .and()
                .formLogin() // for form login authentication
                .and()
                .sessionManagement().disable(); // disable the session
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
