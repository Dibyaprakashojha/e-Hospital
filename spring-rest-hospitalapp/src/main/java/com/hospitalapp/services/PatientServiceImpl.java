package com.hospitalapp.services;

import com.hospitalapp.exceptions.IdNotFoundException;
import com.hospitalapp.exceptions.PatientNotFoundException;
import com.hospitalapp.model.Patient;
import com.hospitalapp.repository.IPatientRepository;
import com.hospitalapp.vo.PatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Service
public class PatientServiceImpl implements IPatientService{
    /**
     * This implementation class is for crud applications on patient table
     * getting all patients by department,city,patientLastName
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
        iPatientRepository.save(patient);
    }

    @Override
    public void deletePatient(int patientId) {
        iPatientRepository.deleteById(patientId);
    }

    @Override
    public Patient getById(int patientId) throws IdNotFoundException {
        return iPatientRepository.findById(patientId).get();
    }

    @Override
    public List<PatientVo> getAll() throws PatientNotFoundException {
        return iPatientRepository.findAll()
                .stream()
                .map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientVo> getByPatientLastName(String patientLastName) throws PatientNotFoundException {
        return iPatientRepository.getByPatientLastName(patientLastName)
                .stream().map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientVo> getByBloodGroup(String bloodGroup) throws PatientNotFoundException {
        return iPatientRepository.getByBloodGroup(bloodGroup)
                .stream()
                .sorted(Comparator.comparing(Patient::getBloodGroup))
                .map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientVo> getByPatientFirstNameBloodGroup(String patientFirstName, String bloodGroup) throws PatientNotFoundException {
        return iPatientRepository.getByPatientFirstNameAndBloodGroup(patientFirstName, bloodGroup)
                .stream()
                .map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientVo> getByPatientFirstNameCity(String patientFirstName, String city) throws PatientNotFoundException {
        return iPatientRepository.getByPatientFirstNameCity(patientFirstName, city)
                .stream()
                .map(this::convertVoToEntity)
                .collect(Collectors.toList());
    }

    private PatientVo convertVoToEntity(Patient patient) {
        PatientVo patientVo = new PatientVo();
        patientVo.setPatientId(patient.getPatientId());
        patientVo.setPatientName(patient.getPatientFirstName()+" "+patient.getPatientLastName());
        patientVo.setGender(patient.getGender());
        patientVo.setAge(patient.getAge());
        patientVo.setBloodGroup(patient.getBloodGroup());
        patientVo.setCity(patient.getAddress().getCity());
        return patientVo;
    }

}
