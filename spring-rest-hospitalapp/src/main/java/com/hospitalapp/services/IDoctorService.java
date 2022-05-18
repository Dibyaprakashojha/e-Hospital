package com.hospitalapp.services;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.exceptions.IdNotFoundException;
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
    void deleteDoctor(int doctorId) throws IdNotFoundException;
    Doctor getById(int doctorId) throws IdNotFoundException;
    List<Doctor> getAll() throws DoctorNotFoundException;

    List<Doctor> getByDoctorFirstName(String doctorFirstName) throws DoctorNotFoundException;
    List<Doctor> getByDoctorLastName(String doctorLastName) throws DoctorNotFoundException;
    List<Doctor> getByFees(double fees) throws DoctorNotFoundException;
    List<Doctor> getByDepartment(String department) throws DoctorNotFoundException;
    List<Doctor> getByDepartmentAndFeesLessThan(String department, double fees) throws DoctorNotFoundException;

    List<Doctor> getByCity(String city) throws DoctorNotFoundException;
    List<Doctor> getByDepartmentCity(String department,String city) throws DoctorNotFoundException;
    List<Doctor> getByDepartmentState(String department,String state) throws DoctorNotFoundException;
    List<Doctor> getByCityFees(String city,double fees) throws DoctorNotFoundException;




}
