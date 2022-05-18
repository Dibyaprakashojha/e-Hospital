package com.hospitalapp.controllers;

import com.hospitalapp.model.Appointment;
import com.hospitalapp.model.Medicine;
import com.hospitalapp.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/appointments/{doctorLastName}")
    public ResponseEntity<List<Appointment>> getAllByDoctor(@PathVariable("doctorLastName") String doctorLastName){
        List<Appointment> appointments = iAppointmentService.getAllByDoctor(doctorLastName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all appointments by doctorLastName"))
                .body(appointments);
    }

    @GetMapping("/appointments/patients/{patientFirstName}")
    public ResponseEntity<List<Appointment>> getByPatientName(@PathVariable("patientFirstName") String patientFirstName) {
        List<Appointment> appointments = iAppointmentService.getByPatientName(patientFirstName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all appointments by patientFirstName"))
                .body(appointments);
    }

    @GetMapping("/appointments/slotStart/{slotStartTime}/slotEnd/{slotEndTime}/dateOfAppointment/{dateOfAppointment}")
    public ResponseEntity<List<Appointment>> getByTimeSlotsAndDateOfAppointment(@PathVariable("slotStartTime") LocalTime slotStartTime,@PathVariable("slotEndTime") LocalTime slotEndTime,@PathVariable("dateOfAppointment") LocalDate dateOfAppointment){
        List<Appointment> appointments = iAppointmentService.getByTimeSlotsAndDateOfAppointment(slotStartTime, slotEndTime, dateOfAppointment);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all appointments by schedule"))
                .body(appointments);
    }
}
