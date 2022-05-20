package com.hospitalapp.controllers;

import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.exceptions.PatientNotFoundException;
import com.hospitalapp.model.Patient;
import com.hospitalapp.services.IPatientService;
import com.hospitalapp.vo.PatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/user/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        iPatientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "adding data for patient"))
                .body(patient);
    }

    @PutMapping("/user/patients")
    public ResponseEntity<Void> updatePatient(@RequestBody Patient patient){
        iPatientService.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "updating data for patient"))
                .build();
    }

    @DeleteMapping("/admin/patients/patientId/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable("patientId") int patientId){
        iPatientService.deletePatient(patientId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "deleting data for patient"))
                .build();
    }

    @GetMapping("/admin/patients/patientId/{patientId}")
    public ResponseEntity<Patient> getById(@PathVariable("patientId") int patientId) throws IdNotFoundException {
        Patient patient = iPatientService.getById(patientId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get data for patient by Id"))
                .body(patient);
    }

    @GetMapping("/admin/patients")
    public ResponseEntity<List<PatientVo>> getAll() throws PatientNotFoundException{
        List<PatientVo> patients = iPatientService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all patients"))
                .body(patients);
    }

    @GetMapping("/admin/patients/patientName/{patientLastName}")
    public ResponseEntity<List<PatientVo>>getByPatientLastName(@PathVariable("patientLastName") String patientLastName) throws PatientNotFoundException{
        List<PatientVo> patients = iPatientService.getByPatientLastName(patientLastName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all patients by patientLastName"))
                .body(patients);
    }

    @GetMapping("/admin/patients/bloodGroup/{bloodGroup}")
    public ResponseEntity<List<PatientVo>>getByBloodGroup(@PathVariable("bloodGroup") String bloodGroup) throws PatientNotFoundException{
        List<PatientVo> patients = iPatientService.getByBloodGroup(bloodGroup);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all patients by bloodGroup"))
                .body(patients);
    }

    @GetMapping("/doctor/patients/patientFirstName/{patientFirstName}/bloodGroup/{bloodGroup}")
    public ResponseEntity<List<PatientVo>>getByPatientFirstNameBloodGroup(@PathVariable("patientFirstName") String patientFirstName,@PathVariable("bloodGroup") String bloodGroup) throws PatientNotFoundException{
        List<PatientVo> patients = iPatientService.getByPatientFirstNameBloodGroup(patientFirstName, bloodGroup);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all patients by patientFirstName and bloodGroup"))
                .body(patients);
    }

    @GetMapping("/doctor/patients/patientName/{patientFirstName}/city/{city}")
    public ResponseEntity<List<PatientVo>>getByPatientFirstNameCity(@PathVariable("patientFirstName") String patientFirstName,@PathVariable("city") String city) throws PatientNotFoundException{
        List<PatientVo> patients = iPatientService.getByPatientFirstNameCity(patientFirstName, city);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all patients by patientFirstName and city"))
                .body(patients);
    }

}
