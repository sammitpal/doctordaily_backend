package com.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.model.ChamberAppointment;
@Service
public interface ChamberAppointmentService {

	public ChamberAppointment createAppointment(ChamberAppointment appointment, String chamberid);
	public List<ChamberAppointment> showAllAppointments(String chamberid);
	
}
