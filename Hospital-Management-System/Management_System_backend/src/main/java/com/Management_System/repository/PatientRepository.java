package com.Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Management_System.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	

}
