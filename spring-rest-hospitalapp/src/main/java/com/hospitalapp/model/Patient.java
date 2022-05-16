package com.hospitalapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(generator = "patient_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "patient_gen",sequenceName = "patient_seq",initialValue = 500,allocationSize = 1)
    @ToString.Exclude
    private Integer patientId;

    @Column(length = 20)
    private String patientFirstName;

    @Column(length = 20)
    private String patientLastName;

    private String gender; // Male/Female/Others

    private int age;

    private String bloodGroup; // O,A,B,AB

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // this address_id will be added as foreign key in patient table
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id") // this patient_id will be added as foreign key in appointment table
    private Set<Appointment> appointments;





}
