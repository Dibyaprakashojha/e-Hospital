package com.hospitalapp.repository;

import com.hospitalapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {

    List<Patient> getByPatientLastName(String patientLastName);
    List<Patient> getByBloodGroup(String bloodGroup);
    List<Patient> getByPatientFirstNameAndBloodGroup(String patientFirstName, String bloodGroup);

    @Query("from Patient p inner join p.address a where p.patientFirstName=?1 and a.city=?1")
    List<Patient> getByPatientFirstNameCity(String patientFirstName,String city);
}
