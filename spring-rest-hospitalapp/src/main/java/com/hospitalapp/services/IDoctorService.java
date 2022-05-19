package com.hospitalapp.services;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.vo.DoctorVo;

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
    List<DoctorVo> getAll() throws DoctorNotFoundException;

    List<DoctorVo> getByDoctorFirstName(String doctorFirstName) throws DoctorNotFoundException;
    List<DoctorVo> getByDoctorLastName(String doctorLastName) throws DoctorNotFoundException;
    List<DoctorVo> getByFees(double fees) throws DoctorNotFoundException;
    List<DoctorVo> getByDepartment(String department) throws DoctorNotFoundException;
    List<DoctorVo> getByDepartmentAndFeesLessThan(String department, double fees) throws DoctorNotFoundException;

    List<DoctorVo> getByCity(String city) throws DoctorNotFoundException;
    List<DoctorVo> getByDepartmentCity(String department,String city) throws DoctorNotFoundException;
    List<Doctor> getByDepartmentState(String department,String state) throws DoctorNotFoundException;
    List<DoctorVo> getByCityFees(String city,double fees) throws DoctorNotFoundException;




}
