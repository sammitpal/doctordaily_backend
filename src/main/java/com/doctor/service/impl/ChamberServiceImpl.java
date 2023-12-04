package com.doctor.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exception.DoctorNotFoundException;
import com.doctor.model.Chamber;
import com.doctor.model.Doctor;
import com.doctor.repository.ChamberRepository;
import com.doctor.repository.DoctorRepository;
import com.doctor.service.ChamberService;

@Service
public class ChamberServiceImpl implements ChamberService{
	
	@Autowired
	ChamberRepository chamberRepository;
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Chamber createChamber(Chamber chamber, String username) {
		
		Doctor foundDoctor =  doctorRepository.findByUsername(username);
		if(foundDoctor==null) {
			throw new DoctorNotFoundException(username+" This doctor is not present in our system.");
		}
		
		chamber.setChamberid(UUID.randomUUID().toString());
		chamber.setDoctor(foundDoctor);
		return chamberRepository.save(chamber);
	}

	@Override
	public List<Chamber> getChamber(String username) {
		Doctor doctor =  doctorRepository.findByUsername(username);	
		if(doctor==null) {
			throw new DoctorNotFoundException(username+" This doctor is not present in our system");
		}
		else {			
			return doctor.getChambers();
		}
	}

}
