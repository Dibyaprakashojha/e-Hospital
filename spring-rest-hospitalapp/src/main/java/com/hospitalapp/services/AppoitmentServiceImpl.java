package com.hospitalapp.services;

import com.hospitalapp.exceptions.AppointmentNotFoundException;
import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.model.Appointment;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.repository.IAppointmentRepository;
import com.hospitalapp.vo.AppointmentDoctorPatientVo;
import com.hospitalapp.vo.DoctorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<AppointmentDoctorPatientVo> getByDoctorName(String doctorLastName) throws AppointmentNotFoundException {
        return iAppointmentRepository.findByDoctorLastName(doctorLastName)
                .stream().map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDoctorPatientVo> getByPatientName(String patientFirstName) throws AppointmentNotFoundException {
        return iAppointmentRepository.findByPatientFirstName(patientFirstName)
                .stream().map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDoctorPatientVo> getByTimeSlotsAndDateOfAppointment(LocalTime slotStartTime, LocalTime slotEndTime, LocalDate dateOfAppointment) throws AppointmentNotFoundException {
        return iAppointmentRepository.findByTimeSlotsAndDateOfAppointment(slotStartTime, slotEndTime, dateOfAppointment)
                .stream().map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }


    private AppointmentDoctorPatientVo convertVoToEntity(Appointment appointment) {
        AppointmentDoctorPatientVo appointmentDoctorPatientVo = new AppointmentDoctorPatientVo();
        appointmentDoctorPatientVo.setAppNumber(appointment.getAppNumber());
        appointmentDoctorPatientVo.setPatientName(appointment.getPatient().getPatientFirstName()+" "+appointment.getPatient().getPatientLastName());
        appointmentDoctorPatientVo.setDateOfAppointment(appointment.getDateOfAppointment());
        appointmentDoctorPatientVo.setSlotStartTime(appointment.getSlotStartTime());
        appointmentDoctorPatientVo.setSlotEndTime(appointment.getSlotEndTime());
        appointmentDoctorPatientVo.setProblem(appointment.getProblem());
        appointmentDoctorPatientVo.setStatus(appointment.getStatus());
        appointmentDoctorPatientVo.setDoctorName(appointment.getDoctor().getDoctorFirstName()+" "+appointment.getDoctor().getDoctorLastName());
        appointmentDoctorPatientVo.setDepartments(appointment.getDoctor().getDepartment().getDepartments());
        appointmentDoctorPatientVo.setFees(appointment.getDoctor().getFees());
        return appointmentDoctorPatientVo;
    }
}
