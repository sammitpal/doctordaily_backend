package com.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String>{

	Doctor findByUsername(String username);

}
