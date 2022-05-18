package com.hospitalapp.services;

import com.hospitalapp.exceptions.AppointmentNotFoundException;
import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.model.Appointment;
import com.hospitalapp.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class AppoitmentServiceImpl implements IAppointmentService{
    private IAppointmentRepository iAppointmentRepository;
    @Autowired
    public void setiAppointmentRepository(IAppointmentRepository iAppointmentRepository) {
        this.iAppointmentRepository = iAppointmentRepository;
    }

    /**
     *
     * @param appointment
     * @return
     * @throws AppointmentNotFoundException
     */
    @Override
    public Appointment addAppointment(Appointment appointment) {
        return iAppointmentRepository.save(appointment);

    }

    @Override
    public void updateAppointment(Appointment appointment) {
        iAppointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(int appointmentId) throws IdNotFoundException {
        iAppointmentRepository.deleteById(appointmentId);
    }

    @Override
    public Appointment getById(int appoitnmentId) throws IdNotFoundException {
        return iAppointmentRepository.findById(appoitnmentId).get();
    }

    @Override
    public List<Appointment> getByDoctorName(String doctorLastName) throws AppointmentNotFoundException {
        return iAppointmentRepository.findByDoctorLastName(doctorLastName);
    }

    @Override
    public List<Appointment> getByPatientName(String patientFirstName) throws AppointmentNotFoundException {
        return iAppointmentRepository.findByPatientFirstName(patientFirstName);
    }

    @Override
    public List<Appointment> getByTimeSlotsAndDateOfAppointment(LocalTime slotStartTime, LocalTime slotEndTime, LocalDate dateOfAppointment) throws AppointmentNotFoundException {
        return iAppointmentRepository.findByTimeSlotsAndDateOfAppointment(slotStartTime, slotEndTime, dateOfAppointment);
    }
}
