package com.hospitalapp.controllers;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.services.IDoctorService;
import com.hospitalapp.vo.DoctorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed("ADMIN")
    public ResponseEntity<List<DoctorVo>> getAll(){
        List<DoctorVo> doctors = iDoctorService.getAll();
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

    @GetMapping("/admin/doctors/doctorName/{doctorFirstName}")
    public ResponseEntity<List<DoctorVo>> getByDoctorFirstName(@PathVariable("doctorFirstName") String doctorFirstName){
        List<DoctorVo> doctors = iDoctorService.getByDoctorFirstName(doctorFirstName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/doctorName/{doctorLastName}")
    public ResponseEntity<List<DoctorVo>> getByDoctorLastName(@PathVariable("doctorLastName") String doctorLastName) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByDoctorLastName(doctorLastName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/fees/{fees}")
    public ResponseEntity<List<DoctorVo>> getByFees(@PathVariable("fees") double fees) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByFees(fees);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}")
    public ResponseEntity<List<DoctorVo>> getByDepartment(@PathVariable("department") String department) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByDepartment(department);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}/fees/{fees}")
    public ResponseEntity<List<DoctorVo>> getByDepartmentAndFeesLessThan(@PathVariable("department") String department,@PathVariable("fees")  double fees) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByDepartmentAndFeesLessThan(department, fees);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/city/{city}")
    public ResponseEntity<List<DoctorVo>> getByCity(@PathVariable("city") String city) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByCity(city);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }

    @GetMapping("/admin/doctors/department/{department}/city/{city}")
    public ResponseEntity<List<DoctorVo>> getByDepartmentCity(@PathVariable("department") String department,@PathVariable("city") String city) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByDepartmentCity(department, city);
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
    public ResponseEntity<List<DoctorVo>> getByCityFees(@PathVariable("city") String city,@PathVariable("fees") double fees) throws DoctorNotFoundException{
        List<DoctorVo> doctors = iDoctorService.getByCityFees(city, fees);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders.add("desc", "get all doctors"))
                .body(doctors);
    }
}
