package com.hospitalapp.services;

import com.hospitalapp.exceptions.AppointmentNotFoundException;
import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.model.Appointment;
import com.hospitalapp.vo.AppointmentDoctorPatientVo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */

public interface IAppointmentService {
    /**
     * This service is for crud applications on appointment table
     * getting all appointments by a particular doctor will be used by the admin module
     */
    Appointment addAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int appointmentId) throws IdNotFoundException;
    Appointment getById(int appoitnmentId) throws IdNotFoundException;

    List<AppointmentDoctorPatientVo> getByDoctorName(String doctorName) throws AppointmentNotFoundException;
    List<AppointmentDoctorPatientVo> getByPatientName(String patientFirstName) throws AppointmentNotFoundException;
    List<AppointmentDoctorPatientVo> getByTimeSlotsAndDateOfAppointment(LocalTime slotStartTime, LocalTime slotEndTime, LocalDate dateOfAppointment) throws AppointmentNotFoundException;
}
