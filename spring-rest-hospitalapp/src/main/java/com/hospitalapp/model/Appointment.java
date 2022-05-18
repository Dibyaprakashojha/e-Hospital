package com.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

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

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    @Column(updatable = false)
//    @Type(type = "uuid_char")
    private String appNumber; // AP5002,AP5003

    private LocalDate dateOfAppointment;

    private LocalTime slotStartTime;

    private LocalTime slotEndTime;

    private String problem;

    private String status; // enum -> INPROGRESS, CONFIRMED,CANCELLED

    @OneToMany(cascade = CascadeType.ALL) // parent-side
    @JoinColumn(name = "appointment_id")
    private Set<Medicine> medicines;

    @ManyToOne
    @JoinColumn(name = "patient_id") // this id will be fk in appointment table
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id") // this id will be fk in appointment table
    private Doctor doctor;

}
