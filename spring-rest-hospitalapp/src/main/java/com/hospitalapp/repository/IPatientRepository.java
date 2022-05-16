package com.hospitalapp.repository;

import com.hospitalapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dibya Prakash Ojha
 * @date : 16-May-22
 * @project : e-Hospital
 */
@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {
}
