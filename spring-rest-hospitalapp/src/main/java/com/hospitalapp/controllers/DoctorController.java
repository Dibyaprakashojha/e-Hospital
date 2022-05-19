package com.hospitalapp.controllers;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.services.IDoctorService;
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
@RequestMapping("/doctor-api")
public class DoctorController {
    private IDoctorService iDoctorService;

    @Autowired
    public void setiDoctorService(IDoctorService iDoctorService) {
        this.iDoctorService = iDoctorService;
    }

    @PostMapping("/admin/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        iDoctorService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "adding data for doctor"))
                .body(doctor);
    }

    @PutMapping("/admin/doctors")
    public ResponseEntity<Void> updateDoctor(@RequestBody Doctor doctor){
        iDoctorService.updateDoctor(doctor);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "update doctors"))
                .build();
    }

    @GetMapping("/admin/doctors")
    public ResponseEntity<List<Doctor>> getAll(){
        List<Doctor> doctors = iDoctorService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @DeleteMapping("/admin/doctors/doctorId/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("doctorId") int doctorId){
        iDoctorService.deleteDoctor(doctorId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "delete doctors"))
                .build();
    }

    @GetMapping("/admin/doctors/doctorId/{doctorId}")
    public ResponseEntity<Doctor> getById(@PathVariable("doctorId") int doctorId){
        Doctor doctor = iDoctorService.getById(doctorId);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get doctor by their Id"))
                .body(doctor);
    }

    @GetMapping("/doctors/doctorName/{doctorFirstName}")
    public ResponseEntity<List<Doctor>> getByDoctorFirstName(@PathVariable("doctorFirstName") String doctorFirstName){
        List<Doctor> doctors = iDoctorService.getByDoctorFirstName(doctorFirstName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/doctorName/{doctorLastName}")
    public ResponseEntity<List<Doctor>> getByDoctorLastName(@PathVariable("doctorLastName") String doctorLastName) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByDoctorLastName(doctorLastName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/fees/{fees}")
    public ResponseEntity<List<Doctor>> getByFees(@PathVariable("fees") double fees) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByFees(fees);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}")
    public ResponseEntity<List<Doctor>> getByDepartment(@PathVariable("department") String department) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByDepartment(department);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}/fees/{fees}")
    public ResponseEntity<List<Doctor>> getByDepartmentAndFeesLessThan(@PathVariable("department") String department,@PathVariable("fees")  double fees) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByDepartmentAndFeesLessThan(department, fees);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/city/{city}")
    public ResponseEntity<List<Doctor>> getByCity(@PathVariable("city") String city) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByCity(city);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}/city/{city}")
    public ResponseEntity<List<Doctor>> getByDepartmentCity(@PathVariable("department") String department,@PathVariable("city") String city) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByDepartmentCity(department, city);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}/state/{state}")
    public ResponseEntity<List<Doctor>> getByDepartmentState(@PathVariable("department") String department,@PathVariable("state") String state) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByDepartmentState(department, state);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/city/{city}/fees/{fees}")
    public ResponseEntity<List<Doctor>> getByCityFees(@PathVariable("city") String city,@PathVariable("fees") double fees) throws DoctorNotFoundException{
        List<Doctor> doctors = iDoctorService.getByCityFees(city, fees);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }
}
