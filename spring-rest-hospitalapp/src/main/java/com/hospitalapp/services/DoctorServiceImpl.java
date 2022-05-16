package com.hospitalapp.services;

import com.hospitalapp.model.Doctor;
import com.hospitalapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
@Service
public class DoctorServiceImpl implements IDoctorService{

    private IDoctorRepository iDoctorRepository;

    @Autowired
    public void setiDoctorRepository(IDoctorRepository iDoctorRepository) {
        this.iDoctorRepository = iDoctorRepository;
    }

    /**
     * This implementation class implements the methods of IDoctorService interface
     * for adding doctor details into the table
     * @param doctor
     * @return One Doctor detail
     */
    @Override
    public Doctor addDoctor(Doctor doctor) {
        return iDoctorRepository.save(doctor);
    }

    /**
     * This method is used to update the details of a doctor
     * @param doctor
     */
    @Override
    public void updateDoctor(Doctor doctor) {
        iDoctorRepository.save(doctor);
    }

    /**
     * This method is used to delete a doctor by doctorId
     * @param doctorId
     */
    @Override
    public void deleteDoctor(int doctorId) {
        iDoctorRepository.deleteById(doctorId);
    }

    /**
     * This method is used to find a doctor by doctorId
     * @param doctorId
     * @return One doctor
     */
    @Override
    public Doctor getById(int doctorId) {
        return iDoctorRepository.findById(doctorId).get();
    }

    /**
     * This method is to find all the doctors present in the table
     * @return List of all doctors
     */
    @Override
    public List<Doctor> getAll() {
        return iDoctorRepository.findAll();
    }

    @Override
    public List<Doctor> getByDoctorFirstName(String doctorFirstName) {
        return null;
    }

    @Override
    public List<Doctor> getByDoctorLastName(String doctorLastName) {
        return null;
    }

    @Override
    public List<Doctor> getByFees(double fees) {
        return null;
    }

    @Override
    public List<Doctor> getByDepartment(String department) {
        return null;
    }

    @Override
    public List<Doctor> getByDepartmentAndFees(String department, double fees) {
        return null;
    }

    @Override
    public List<Doctor> getByCity(String city) {
        return null;
    }

    @Override
    public List<Doctor> getByDepartmentCity(String department, String city) {
        return null;
    }

    @Override
    public List<Doctor> getByDepartmentState(String department, String state) {
        return null;
    }

    @Override
    public List<Doctor> getByCityFees(String city, double fees) {
        return null;
    }
    /**
     * This implementation class is for crud applications on doctor table
     * getting all doctors by department,city,patientLastName
     */


}
