package com.hospitalapp.services;

import com.hospitalapp.model.Appointment;
import com.hospitalapp.model.Patient;
import com.hospitalapp.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class PatientServiceImpl implements IPatientService{
    /**
     * This implementation class is for crud applications on doctor table
     * getting all doctors by department,city,patientLastName
     */
    private IPatientRepository iPatientRepository;
    @Autowired
    public void setiPatientRepository(IPatientRepository iPatientRepository) {
        this.iPatientRepository = iPatientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    /**
     *
     * @param patient
     */
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
        return iPatientRepository.findAll();
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
