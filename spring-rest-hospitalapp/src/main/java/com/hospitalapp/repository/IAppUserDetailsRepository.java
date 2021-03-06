package com.hospitalapp.repository;

import com.hospitalapp.model.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Repository
public interface IAppUserDetailsRepository extends JpaRepository<AppUserDetails,Integer> {
    /**
     *
     * @param email
     * @return The user by the unique email
     */
    AppUserDetails findByEmail(String email);
}
