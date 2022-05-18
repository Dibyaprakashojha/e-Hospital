package com.hospitalapp.services;

import com.hospitalapp.model.Doctor;
import com.hospitalapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
     * @return One Particular Doctor detail
     */
    @Override
    @Transactional
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

    /**
     *
     * @param doctorFirstName
     * @return
     */
    @Override
    public List<Doctor> getByDoctorFirstName(String doctorFirstName) {
        return iDoctorRepository.findByDoctorFirstName(doctorFirstName)
                .stream().sorted(Comparator.comparing(Doctor::getDoctorFirstName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param doctorLastName
     * @return
     */
    @Override
    public List<Doctor> getByDoctorLastName(String doctorLastName) {
        return iDoctorRepository.findByDoctorLastName(doctorLastName)
                .stream().sorted(Comparator.comparing(Doctor::getDoctorLastName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param fees
     * @return
     */
    @Override
    public List<Doctor> getByFees(double fees) {
        return iDoctorRepository.findByFeesLessThan(fees)
                .stream().sorted(Comparator.comparing(Doctor::getFees))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param department
     * @return
     */
    @Override
    public List<Doctor> getByDepartment(String department) {
        return iDoctorRepository.findByDepartment(department)
                .stream().sorted(Comparator.comparing(Doctor::getDoctorFirstName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param department
     * @param fees
     * @return
     */
    @Override
    public List<Doctor> getByDepartmentAndFeesLessThan(String department, double fees) {
        return iDoctorRepository.findByDepartmentAndFeesLessThan(department, fees)
                .stream().sorted(Comparator.comparing(Doctor::getDoctorFirstName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param city
     * @return
     */
    @Override
    public List<Doctor> getByCity(String city) {
        return iDoctorRepository.findByCity(city);
    }

    /**
     *
     * @param department
     * @param city
     * @return
     */
    @Override
    public List<Doctor> getByDepartmentCity(String department, String city) {
        return iDoctorRepository.findByDepartmentCity(department, city);
    }

    /**
     *
     * @param department
     * @param state
     * @return
     */
    @Override
    public List<Doctor> getByDepartmentState(String department, String state) {
        return iDoctorRepository.findByDepartmentState(department, state);
    }

    /**
     *
     * @param city
     * @param fees
     * @return
     */
    @Override
    public List<Doctor> getByCityFees(String city, double fees) {
        return iDoctorRepository.findByCityFees(city, fees);
    }

}
