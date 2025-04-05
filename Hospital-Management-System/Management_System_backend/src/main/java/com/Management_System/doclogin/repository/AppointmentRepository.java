package com.Management_System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Management_System.doclogin.entity.Appointments;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> {

}
