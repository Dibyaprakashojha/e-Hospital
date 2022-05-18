package com.hospitalapp.services;

import com.hospitalapp.model.AppUserDetails;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.hospitalapp.repository.IAppUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class AppUserDetailsServiceImpl implements UserDetailsService,IAppUserDetailsService {

    @Autowired
    private IAppUserDetailsRepository iAppUserDetailsRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get the user by passing the emailId
        AppUserDetails appUserDetails = iAppUserDetailsRepository.findByEmailId(username);
        String username1 = appUserDetails.getEmailId();
        String password = appUserDetails.getPassword();

        // set the roles
        GrantedAuthority grantedAuthority1 = new SimpleGrantedAuthority("ADMIN");
        GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("DOCTOR");
        GrantedAuthority grantedAuthority3 = new SimpleGrantedAuthority("PATIENT");
        UserDetails userDetails = new User(username1, password, Arrays.asList(grantedAuthority1,grantedAuthority2,grantedAuthority3));
        return userDetails;
    }

    @Override
    public void addUser(AppUserDetails userDetails) {
        iAppUserDetailsRepository.save(userDetails);
    }

    @Override
    public void updateUser(AppUserDetails user) {
        iAppUserDetailsRepository.save(user);
    }

    @Override
    public void deleteUser(int userDetailsId) {
        iAppUserDetailsRepository.deleteById(userDetailsId);
    }

}
