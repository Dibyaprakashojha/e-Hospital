package com.hospitalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
/**
 *
 *  <p> This class is for storing the registration details of the users
 *  (patients,doctor,pharmacist,admin) </p>
 *
 */
public class AppUserDetails {
    @Id
    @GeneratedValue
    private Integer userDetailsId;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

//    @Column(length = 255,unique = true)
    private String emailId;

    private String password;

    private String roles; // this param is the role assigned to a user (ADMIN,DOCTOR,PATIENT,PHARMACIST)

    public AppUserDetails(String firstName, String lastName, String emailId, String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = this.emailId;
        this.password = password;
        this.roles = roles;
    }
}
