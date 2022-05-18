package com.hospitalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    // authentication using jpa
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // using the object of the class that implements UserDetailsService
//        auth.userDetailsService(userDetailsService);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable() // disable the csrf attack
                .authorizeRequests()
                .antMatchers("/")
                    .hasRole("ADMIN") // permit this url to Admin only
                .antMatchers("/doctor-api/doctors","/appointment-api/appointments/doctors/**")
                    .hasRole("DOCTOR")
                .antMatchers("/appointment-api/appointments","/appointment-api/appointments/delete-appointment/**")
                    .hasRole("PATIENT")
                .and()
                .httpBasic() // for basic authentication
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
