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
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Department {
    @Id
    @GeneratedValue(generator = "department_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "department_gen",sequenceName = "department_seq",initialValue = 1000,allocationSize = 100)
    @ToString.Exclude
    private Integer departmentId;

    @Column(length = 40)
    private String departments; // Onco,Cardio,Ent,Neuro,Physio,Ortho,Opthalmo,Gynaec,Nephro

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    // this mappedBy(department) will be attached to doctor table
    @ToString.Exclude
    @JsonIgnore
    private Set<Doctor> doctors;


    public Department(String departments) {
        this.departments = departments;
    }
}
