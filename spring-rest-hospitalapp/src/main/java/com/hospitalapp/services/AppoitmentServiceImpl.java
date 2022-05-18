package com.hospitalapp.services;

import com.hospitalapp.model.Appointment;
import com.hospitalapp.model.Patient;
import com.hospitalapp.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return iAppointmentRepository.save(appointment);

    }

    @Override
    public void updateAppointment(Appointment appointment) {
        iAppointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(int appointmentId) {
        iAppointmentRepository.deleteById(appointmentId);
    }

    @Override
    public Appointment getById(int appoitnmentId) {
        return iAppointmentRepository.findById(appoitnmentId).get();
    }

    @Override
    public List<Appointment> getAllByDoctor(String doctorLastName) {
        return iAppointmentRepository.findByDoctorLastName(doctorLastName);
    }

    @Override
    public List<Appointment> getByPatientName(String patientFirstName) {
        return iAppointmentRepository.findByPatientFirstName(patientFirstName);
    }

    @Override
    public List<Appointment> getByTimeSlotsAndDateOfAppointment(LocalTime slotStartTime, LocalTime slotEndTime, LocalDate dateOfAppointment) {
        return iAppointmentRepository.findByTimeSlotsAndDateOfAppointment(slotStartTime, slotEndTime, dateOfAppointment);
    }
}
