package com.hospitalapp.services;

import com.hospitalapp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
public interface IPatientService {
 /**
 * This service is for crud applications on patient table
 * getting all patients by bloodGroup,city,patientLastName
 */
    Patient addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(int patientId);
    Patient getById(int patientId);
    List<Patient> getAll();

    List<Patient> getByPatientLastName(String patientLastName);
    List<Patient> getByBloodGroup(String bloodGroup);

    List<Patient> getByPatientFirstNameBloodGroup(String patientLastName,String bloodGroup);
    List<Patient> getByPatientFirstNameCity(String patientLastName,String city);


}
