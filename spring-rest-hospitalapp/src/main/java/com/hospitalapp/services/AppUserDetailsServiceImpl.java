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

    private IAppUserDetailsRepository iAppUserDetailsRepository;

    @Autowired
    public void setiAppUserDetailsRepository(IAppUserDetailsRepository iAppUserDetailsRepository) {
        this.iAppUserDetailsRepository = iAppUserDetailsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get the user by passing the email
        AppUserDetails appUserDetails = iAppUserDetailsRepository.findByEmail(username);
        if (appUserDetails == null)
            throw new UsernameNotFoundException("User Id Not Found");
        String username1 = appUserDetails.getEmail();
        String password = appUserDetails.getPassword();

        // set the roles
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUserDetails.getRoles());
        UserDetails userDetails = new User(username1, password, Arrays.asList(grantedAuthority));
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
