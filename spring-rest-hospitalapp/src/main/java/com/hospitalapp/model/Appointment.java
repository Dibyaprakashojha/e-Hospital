package com.hospitalapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
public class Appointment {
    @Id
    @GeneratedValue(generator = "appointment_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "appointment_gen",sequenceName = "appointment_seq",initialValue = 100,allocationSize = 1)
    @ToString.Exclude
    private Integer appointmentId;

    @Column(length = 20,unique = true)
    private String appNumber;

    private LocalDateTime dateTimeOfAppointment;

    private String problem;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id") // this id will be foreign key in medicine table
    private Set<Medicine> medicines;

    @ManyToOne
    @JoinColumn(name = "patient_id") // this id will be fk in appointment table
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id") // this id will be fk in appointment table
    private Doctor doctor;


    public Appointment(String appNumber, LocalDateTime dateTimeOfAppointment, String problem, Patient patient, Doctor doctor) {
        this.appNumber = appNumber;
        this.dateTimeOfAppointment = dateTimeOfAppointment;
        this.problem = problem;
        this.patient = patient;
        this.doctor = doctor;
    }
}
