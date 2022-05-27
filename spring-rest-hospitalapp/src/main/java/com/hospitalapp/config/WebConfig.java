package com.hospitalapp.config;

import com.hospitalapp.services.AppUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password, enabled from app_user_details where email=?")
                .authoritiesByUsernameQuery("select email,roles from app_user_details where email=?");
    }

    // authentication using jpa
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new AppUserDetailsServiceImpl();
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable() // disable the csrf attack
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN')") // permit this url to Admin only
                .antMatchers("/doctor/**").access("hasRole('DOCTOR')")
                .antMatchers("/user/**","/appointment-api/appointments","/appointment-api/appointments/delete-appointment/**").access("hasRole('USER')")
                .antMatchers( "/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin() // for form login authentication
                .and()
//                .logout()
//                .permitAll()
//                .and()
                .sessionManagement().disable(); // disable the session

//        http
////        .authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().permitAll()
////                .and()
////                .logout().permitAll();
//
//        .authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }


}
