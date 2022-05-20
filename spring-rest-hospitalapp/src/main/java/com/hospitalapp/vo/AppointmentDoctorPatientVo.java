package com.hospitalapp.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Dibya Prakash Ojha
 * @date : 20-May-22
 * @project : e-Hospital
 */
@Getter
@Setter
public class AppointmentDoctorPatientVo {
    private String appNumber;

    private String patientName;

    private LocalDate dateOfAppointment;

    private LocalTime slotStartTime;

    private LocalTime slotEndTime;

    private String problem;

    private String status;

    private String doctorName;

    private String departments;

    private double fees;

}
