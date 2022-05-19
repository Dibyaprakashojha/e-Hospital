package com.hospitalapp.controllers;

import com.hospitalapp.model.AppUserDetails;
import com.hospitalapp.services.IAppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@RestController
public class AppUserDetailsController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserDetailsService iAppUserDetailsService;


    @PostMapping("/register")
    public void addUser(@RequestBody AppUserDetails appUserDetails) {
        String firstName = appUserDetails.getFirstName();
        String lastName = appUserDetails.getLastName();
        String username = appUserDetails.getEmail();
        String password = appUserDetails.getPassword();
        String roles = appUserDetails.getRoles();
        // encode the password before saving to the dB
        String encodedPassword = passwordEncoder.encode(password);

        AppUserDetails appUser1 = new AppUserDetails(firstName,lastName,username, encodedPassword, roles);
        iAppUserDetailsService.addUser(appUser1);
    }
}
