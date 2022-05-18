package com.hospitalapp.repository;

import com.hospitalapp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Integer> {
    /**
     * @param doctorLastName
     * @return List of Appointments by doctor's lastName
     */
    @Query("from Appointment a inner join a.doctor d where d.doctorLastName=?1")
    List<Appointment> findByDoctorLastName(String doctorLastName);

    @Query("from Appointment a inner join a.patient p where p.patientFirstName=?1")
    List<Appointment> findByPatientFirstName(String patientFirstName);

    @Query("from Appointment a where a.slotStartTime=?1 and a.slotEndTime=?2 and a.dateOfAppointment=?3")
    List<Appointment> findByTimeSlotsAndDateOfAppointment(LocalTime slotStartTime, LocalTime slotEndTime, LocalDate dateOfAppointment);
}
