package com.hospitalapp.model;

import lombok.*;

import javax.persistence.*;
/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_gen",sequenceName = "address_seq",initialValue = 50,allocationSize = 1)
    @ToString.Exclude
    private Integer addressId;

    @Column(length = 30)
    private String city;

    @Column(length = 30)
    private String state;

    private long zipcode;


    public Address(String city, String state, long zipcode) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
