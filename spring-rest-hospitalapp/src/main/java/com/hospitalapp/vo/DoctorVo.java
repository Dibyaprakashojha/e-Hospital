package com.hospitalapp.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospitalapp.model.Department;
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
public class DoctorVo {

    private Integer doctorId;

    private String doctorName;

    private String gender;

    private double fees;

    private String departments;

    private String city;

}
