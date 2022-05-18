package com.hospitalapp.services;

import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.exceptions.PatientNotFoundException;
import com.hospitalapp.model.Patient;
import com.hospitalapp.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Patient getById(int patientId) throws IdNotFoundException {
        return null;
    }

    @Override
    public List<Patient> getAll() throws PatientNotFoundException {
        return iPatientRepository.findAll();
    }

    @Override
    public List<Patient> getByPatientLastName(String patientLastName) throws PatientNotFoundException {
        return null;
    }

    @Override
    public List<Patient> getByBloodGroup(String bloodGroup) throws PatientNotFoundException {
        return null;
    }

    @Override
    public List<Patient> getByPatientFirstNameBloodGroup(String patientFirstName, String bloodGroup) throws PatientNotFoundException {
        return null;
    }

    @Override
    public List<Patient> getByPatientFirstNameCity(String patientFirstName, String city) throws PatientNotFoundException {
        return null;
    }
}
