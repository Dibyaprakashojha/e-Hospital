package com.hospitalapp.repository;

import com.hospitalapp.model.Doctor;
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
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByDoctorFirstName(String doctorFirstName);
    List<Doctor> findByDoctorLastName(String doctorLastName);
    List<Doctor> findByFeesLessThan(double fees);
    List<Doctor> findByDepartment(String department);
    List<Doctor> findByDepartmentAndFeesLessThan(String department,double fees);

    @Query("from Doctor d inner join d.address a where a.city=?1")
    List<Doctor> findByCity(String city);

    @Query("from Doctor d inner join d.address a where d.department=?1 and a.city=?2")
    List<Doctor> findByDepartmentCity(String department,String city);

    @Query("from Doctor d inner join d.address a where d.department=?1 and a.state=?2")
    List<Doctor> findByDepartmentState(String department,String state);

    @Query("from Doctor d inner join d.address a where a.city=?1 and d.fees<=?2")
    List<Doctor> findByCityFees(String city,double fees);

}
