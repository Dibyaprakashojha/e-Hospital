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
public class Medicine {
    @Id
    @GeneratedValue(generator = "medicine_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "medicine_gen",sequenceName = "medicine_seq",initialValue = 125,allocationSize = 1)
    @ToString.Exclude
    private Integer medicineId;

    @Column(length = 60)
    private String prescription;

    private int quantity;

    private double price;


    public Medicine(String prescription, int quantity, double price) {
        this.prescription = prescription;
        this.quantity = quantity;
        this.price = price;
    }
}
