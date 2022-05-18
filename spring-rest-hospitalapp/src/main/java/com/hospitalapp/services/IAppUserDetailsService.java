package com.hospitalapp.services;

import com.hospitalapp.model.AppUserDetails;

/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
public interface IAppUserDetailsService {
    /**
     * This service is for storing,updating and deleting the userDetails details in AppUserDetails table
     * will be used by users(patients) and the admin module
     */
    void addUser(AppUserDetails userDetails);
    void updateUser(AppUserDetails user);
    void deleteUser(int userDetailsId);
}
