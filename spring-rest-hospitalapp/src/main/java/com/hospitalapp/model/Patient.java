package com.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    @ToString.Exclude
    @JsonIgnore
    private Set<Appointment> appointments;
}
