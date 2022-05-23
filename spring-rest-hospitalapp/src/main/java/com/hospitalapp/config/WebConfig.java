package com.hospitalapp.config;

import com.hospitalapp.services.AppUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    // authentication using jpa

    @Bean
    public UserDetailsService userDetailsService() {
        return new AppUserDetailsServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable() // disable the csrf attack
                .authorizeRequests()
                .antMatchers("/admin/**")
                    .hasRole("ADMIN") // permit this url to Admin only
                .antMatchers("/doctor/**")
                    .hasRole("DOCTOR")
                .antMatchers("/user/**","/appointment-api/appointments","/appointment-api/appointmentsdelete-appointment/**")
                    .hasRole("USER")
                .antMatchers( "/register")
                    .permitAll()
                .and()
                .formLogin()
                    .permitAll() // for form login authentication
                .and()
                .logout()
                    .permitAll()
                    .and()
                .sessionManagement().disable(); // disable the session
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
