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
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctor_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "doctor_gen",sequenceName = "doctor_seq",initialValue = 1,allocationSize = 1)
    @ToString.Exclude
    private Integer doctorId;

    @Column(length = 20)
    private String doctorFirstName;

    @Column(length = 20)
    private String doctorLastName;

    private String gender; // Male/Female/Others

    private double fees;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // this address_id will be added as foreign key in doctor table
    private Address address;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "doctor_id")
    @ToString.Exclude
    @JsonIgnore
    private Set<Appointment> appointments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id") // this department_id will be added as foreign key in doctor table
    @ToString.Exclude
    private Department department;  // Onco,Cardio,Ent,Neuro,Physio,Ortho,Opthalmo,Gynaec,Nephro


}
