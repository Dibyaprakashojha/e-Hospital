package com.hospitalapp.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospitalapp.model.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Dibya Prakash Ojha
 * @date : 20-May-22
 * @project : e-Hospital
 */
@Getter
@Setter
public class PatientVo {

    private Integer patientId;

    private String patientName;

    private String gender;

    private int age;

    private String bloodGroup;

    private String city;

}
