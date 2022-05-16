package com.hospitalapp.services;

import com.hospitalapp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class PatientServiceImpl implements IPatientService{
    @Override
    public Patient addPatient(Patient patient) {
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public void deletePatient(int patientId) {

    }

    @Override
    public Patient getById(int patientId) {
        return null;
    }

    @Override
    public List<Patient> getAll() {
        return null;
    }

    @Override
    public List<Patient> getByPatientLastName(String patientLastName) {
        return null;
    }

    @Override
    public List<Patient> getByBloodGroup(String bloodGroup) {
        return null;
    }

    @Override
    public List<Patient> getByPatientFirstNameBloodGroup(String patientLastName, String bloodGroup) {
        return null;
    }

    @Override
    public List<Patient> getByPatientFirstNameCity(String patientLastName, String city) {
        return null;
    }
}
