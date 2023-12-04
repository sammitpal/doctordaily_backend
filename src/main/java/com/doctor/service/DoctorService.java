package com.doctor.service;

import org.springframework.stereotype.Service;

import com.doctor.model.Doctor;
import com.doctor.model.SuccessReponse;
@Service
public interface DoctorService {

	public SuccessReponse savedDoctor(Doctor doctor);
	public Doctor getDoctorData(String username);
	
}
