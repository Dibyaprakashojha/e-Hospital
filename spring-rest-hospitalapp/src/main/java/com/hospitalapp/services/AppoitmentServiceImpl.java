package com.hospitalapp.services;

import com.hospitalapp.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class AppoitmentServiceImpl implements IAppointmentService{
    @Override
    public Appointment addAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public void deleteAppointment(int appointmentId) {

    }

    @Override
    public Appointment getById(int appoitnmentId) {
        return null;
    }

    @Override
    public List<Appointment> getAllByDoctor(String doctorName) {
        return null;
    }
}
