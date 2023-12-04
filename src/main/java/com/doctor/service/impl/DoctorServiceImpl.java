package com.doctor.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exception.DoctorFoundException;
import com.doctor.exception.DoctorNotFoundException;
import com.doctor.exception.GeneralException;
import com.doctor.model.Doctor;
import com.doctor.model.SuccessReponse;
import com.doctor.repository.DoctorRepository;
import com.doctor.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public SuccessReponse savedDoctor(Doctor doctor) {
		
		Doctor foundDoctor = doctorRepository.findByUsername(doctor.getUsername());
		
		if(foundDoctor!=null) {
			throw new DoctorFoundException("This doctor has already registered and completed his profile");
		}
		
		try {
			doctor.setDoctorId(UUID.randomUUID().toString());
			doctorRepository.save(doctor);
			SuccessReponse successReponse = new SuccessReponse();
			successReponse.setMsg("Doctor has been registered");
			return successReponse;
		} catch (Exception e) {
			throw new GeneralException("Something went wrong! Please try again later or contact the Administrator");
		}
	}

	@Override
	public Doctor getDoctorData(String username) {
		Doctor foundDoctor = doctorRepository.findByUsername(username);
		if(foundDoctor==null) {
			throw new DoctorNotFoundException("Doctor Not Found");
		}
		else {
			return foundDoctor;
		}
	}

}
