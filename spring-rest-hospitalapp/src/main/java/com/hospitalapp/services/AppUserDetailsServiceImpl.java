package com.hospitalapp.services;

import com.hospitalapp.model.AppUserDetails;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class AppUserDetailsServiceImpl implements UserDetailsService,IAppUserDetailsService {

    /**
     * This method provides a particular userDetails information
     * @param username
     * @return The UserDetails required for authentication(username, password, role)
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void addUser(AppUserDetails user) {

    }

    @Override
    public void updateUser(AppUserDetails user) {

    }

    @Override
    public void deleteUser(int userDetailsId) {

    }

}
