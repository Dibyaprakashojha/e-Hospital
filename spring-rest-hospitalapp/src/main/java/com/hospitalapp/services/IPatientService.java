package com.hospitalapp.services;

import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.exceptions.PatientNotFoundException;
import com.hospitalapp.model.Patient;
import com.hospitalapp.vo.PatientVo;

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
    Patient getById(int patientId)  throws IdNotFoundException;
    List<PatientVo> getAll() throws PatientNotFoundException;

    List<PatientVo> getByPatientLastName(String patientLastName) throws PatientNotFoundException;
    List<PatientVo> getByBloodGroup(String bloodGroup) throws PatientNotFoundException;

    List<PatientVo> getByPatientFirstNameBloodGroup(String patientFirstName,String bloodGroup) throws PatientNotFoundException;
    List<PatientVo> getByPatientFirstNameCity(String patientFirstName,String city) throws PatientNotFoundException;


}
