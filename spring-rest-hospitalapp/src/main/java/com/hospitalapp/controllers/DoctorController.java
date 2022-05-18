package com.hospitalapp.controllers;

import com.hospitalapp.model.Doctor;
import com.hospitalapp.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
@RequestMapping("/doctor-api")
public class DoctorController {
    private IDoctorService iDoctorService;

    @Autowired
    public void setiDoctorService(IDoctorService iDoctorService) {
        this.iDoctorService = iDoctorService;
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        iDoctorService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "adding data for doctor"))
                .body(doctor);
    }

    @PutMapping("/doctors")
    public ResponseEntity<Void> updateDoctor(@RequestBody Doctor doctor){
        iDoctorService.updateDoctor(doctor);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "update doctors"))
                .build();
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAll(){
        List<Doctor> doctors = iDoctorService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @DeleteMapping("/doctors/doctorId/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("doctorId") int doctorId){
        iDoctorService.deleteDoctor(doctorId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "delete doctors"))
                .build();
    }

    @GetMapping("/doctors/doctorId/{doctorId}")
    public ResponseEntity<Doctor> getById(@PathVariable("doctorId") int doctorId){
        Doctor doctor = iDoctorService.getById(doctorId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get doctor by their Id"))
                .body(doctor);
    }

    @GetMapping("/doctors/doctorName/{doctorFirstName}")
    public ResponseEntity<List<Doctor>>getByDoctorFirstName(@PathVariable("doctorFirstName") String doctorFirstName){
        List<Doctor> doctors = iDoctorService.getByDoctorFirstName(doctorFirstName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }


//    List<Doctor> getByDoctorLastName(String doctorLastName){
//
//    }
//    List<Doctor> getByFees(double fees){
//
//    }
//    List<Doctor> getByDepartment(String department){
//
//    }
//    List<Doctor> getByDepartmentAndFeesLessThan(String department, double fees){
//
//    }
//
//    List<Doctor> getByCity(String city){
//
//    }
//    List<Doctor> getByDepartmentCity(String department,String city){
//
//    }
//    List<Doctor> getByDepartmentState(String department,String state){
//
//    }
//    List<Doctor> getByCityFees(String city,double fees){
//
//    }

}
