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
public class Medicine {
    @Id
    @GeneratedValue(generator = "medicine_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "medicine_gen",sequenceName = "medicine_seq",initialValue = 125,allocationSize = 1)
    @ToString.Exclude
    private Integer medicineId;

    @Column(length = 30)
    private String medicineName;

    @Column(length = 60)
    private String prescription;

    private int quantity;

    private double price;

    @ManyToOne  // child-side
    @JoinColumn(name = "appointment_id") // this id will be foreign key in medicine table
    @JsonIgnore
    private Appointment appointment;


    public Medicine(String medicineName,String prescription, int quantity, double price) {
        this.medicineName = medicineName;
        this.prescription = prescription;
        this.quantity = quantity;
        this.price = price;
    }
}
