package com.hospitalapp.controllers;

import com.hospitalapp.exceptions.AppointmentNotFoundException;
import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.model.Appointment;
import com.hospitalapp.services.IAppointmentService;
import com.hospitalapp.vo.AppointmentDoctorPatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@RestController
@RequestMapping("/appointment-api")
public class AppointmentController {

    private IAppointmentService iAppointmentService;
    @Autowired
    public void setiAppointmentService(IAppointmentService iAppointmentService) {
        this.iAppointmentService = iAppointmentService;
    }

    /**
     * <p>This controller is to add appointments i.e. to create an appointment by the user with the doctor</p>
     *
     * @see <a href="http://localhost:8098/appointment-api/appointments">Add Appointment</a>
     *
     * @param appointment
     * @return The appointment object added
     */
    @PostMapping("/appointments")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        iAppointmentService.addAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "adding data for appointment"))
                .body(appointment);
    }

    @PutMapping("/appointments")
    public ResponseEntity<Void> updateAppointment(@RequestBody Appointment appointment){
        iAppointmentService.updateAppointment(appointment);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "update appointments"))
                .build();
    }

    @DeleteMapping("/appointments/delete-appointment/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(int appointmentId) throws IdNotFoundException {
        iAppointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "delete appointment"))
                .build();
    }

    @GetMapping("/appointments/appointmentId/{appointmentId}")
    public ResponseEntity<Appointment> getById(@PathVariable("appointmentId") int appoitnmentId) throws IdNotFoundException {
        Appointment appointment = iAppointmentService.getById(appoitnmentId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "getting by appointmentId"))
                .body(appointment);
    }

    @GetMapping("/doctor/appointments/doctors/{doctorLastName}")
    public ResponseEntity<List<AppointmentDoctorPatientVo>> getByDoctorName(@PathVariable("doctorLastName") String doctorLastName) throws AppointmentNotFoundException {
        List<AppointmentDoctorPatientVo> appointments = iAppointmentService.getByDoctorName(doctorLastName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all appointments by doctorLastName"))
                .body(appointments);
    }

    @GetMapping("/appointments/patients/{patientFirstName}")
    public ResponseEntity<List<AppointmentDoctorPatientVo>> getByPatientName(@PathVariable("patientFirstName") String patientFirstName) throws AppointmentNotFoundException{
        List<AppointmentDoctorPatientVo> appointments = iAppointmentService.getByPatientName(patientFirstName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all appointments by patientFirstName"))
                .body(appointments);
    }

    @GetMapping("/appointments/slotStart/{slotStartTime}/slotEnd/{slotEndTime}/dateOfAppointment/{dateOfAppointment}")
    public ResponseEntity<List<AppointmentDoctorPatientVo>> getByTimeSlotsAndDateOfAppointment(@PathVariable("slotStartTime") LocalTime slotStartTime,@PathVariable("slotEndTime") LocalTime slotEndTime,@PathVariable("dateOfAppointment") LocalDate dateOfAppointment) throws AppointmentNotFoundException{
        List<AppointmentDoctorPatientVo> appointments = iAppointmentService.getByTimeSlotsAndDateOfAppointment(slotStartTime, slotEndTime, dateOfAppointment);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all appointments by schedule"))
                .body(appointments);
    }
}
