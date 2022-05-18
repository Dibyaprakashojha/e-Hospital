package com.hospitalapp.controllers;

import com.hospitalapp.model.Appointment;
import com.hospitalapp.model.Patient;
import com.hospitalapp.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@RestController
@RequestMapping("/patient-api")
public class PatientController {
    private IPatientService iPatientService;

    @Autowired
    public void setiPatientService(IPatientService iPatientService) {
        this.iPatientService = iPatientService;
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
//        Set<Appointment> appointmentSet = patient.getAppointments();
//        Set<Appointment> appointments = new HashSet<>(appointmentSet);
//        appointmentSet.forEach(appointment -> appointment.getPatient().setAppointments(appointments));
        iPatientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "adding data for patient"))
                .body(patient);
    }

    @PutMapping("/patients")
    public ResponseEntity<Void> updatePatient(@RequestBody Patient patient){
        iPatientService.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "updating data for patient"))
                .build();
    }

    @DeleteMapping("/patients/patientId/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable("patientId") int patientId){
        iPatientService.deletePatient(patientId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "deleting data for patient"))
                .build();
    }

    @GetMapping("/patients/patientId/{patientId}")
    public ResponseEntity<Patient> getById(int patientId){
        Patient patient = iPatientService.getById(patientId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get data for patient by Id"))
                .body(patient);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAll(){
        List<Patient> patients = iPatientService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all patients"))
                .body(patients);
    }


}
