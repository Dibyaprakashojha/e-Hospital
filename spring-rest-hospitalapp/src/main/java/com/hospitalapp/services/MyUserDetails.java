package com.hospitalapp.services;

import com.hospitalapp.model.AppUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Dibya Prakash Ojha
 * @date : 23-May-22
 * @project : e-Hospital
 */
public class MyUserDetails implements UserDetails {

    private AppUserDetails appUserDetails;

    public MyUserDetails(AppUserDetails appUserDetails) {
        this.appUserDetails = appUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority =
                new SimpleGrantedAuthority(appUserDetails.getRoles());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return appUserDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return appUserDetails.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
