package com.hospitalapp.services;

import com.hospitalapp.model.Doctor;

import java.util.List;
/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */

public interface IDoctorService {
    /**
     * This service is for crud applications on doctor table
     * getting all doctors by department,city,patientLastName
     */
    Doctor addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int doctorId);
    Doctor getById(int doctorId);
    List<Doctor> getAll();

    List<Doctor> getByDoctorFirstName(String doctorFirstName);
    List<Doctor> getByDoctorLastName(String doctorLastName);
    List<Doctor> getByFees(double fees);
    List<Doctor> getByDepartment(String department);
    List<Doctor> getByDepartmentAndFees(String department,double fees);

    List<Doctor> getByCity(String city);
    List<Doctor> getByDepartmentCity(String department,String city);
    List<Doctor> getByDepartmentState(String department,String state);
    List<Doctor> getByCityFees(String city,double fees);




}
