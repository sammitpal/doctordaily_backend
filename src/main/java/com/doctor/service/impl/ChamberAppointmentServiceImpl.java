package com.doctor.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.exception.ChamberNotFoundException;
import com.doctor.model.Chamber;
import com.doctor.model.ChamberAppointment;
import com.doctor.repository.ChamberAppointmentRepository;
import com.doctor.repository.ChamberRepository;
import com.doctor.service.ChamberAppointmentService;
@Service
public class ChamberAppointmentServiceImpl implements ChamberAppointmentService{

	@Autowired
	ChamberRepository chamberRepository;
	
	@Autowired
	ChamberAppointmentRepository chamberAppointmentRepository;
	
	@Override
	public ChamberAppointment createAppointment(ChamberAppointment chamberappointment, String chamberid) {
		Chamber foundChamber = chamberRepository.findById(chamberid).orElseThrow(()-> new ChamberNotFoundException("Chamber Not Found"));
		
		if(foundChamber!=null) {
			chamberappointment.setAppointmentId(UUID.randomUUID().toString());
			chamberappointment.setChamber(foundChamber);
			return chamberAppointmentRepository.save(chamberappointment);
		}
		return null;
	}

	@Override
	public List<ChamberAppointment> showAllAppointments(String chamberid) {
		Chamber foundChamber = chamberRepository.findById(chamberid).orElseThrow(()->new ChamberNotFoundException("Chamber not found"));
		return chamberAppointmentRepository.findByChamber(foundChamber);
	}

}
