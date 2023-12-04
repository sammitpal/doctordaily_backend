package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.model.ChamberAppointment;
import com.doctor.model.service.ChamberAppointmentService;

@RestController
@RequestMapping("/api")
public class ChamberAppointmentController {

	@Autowired
	ChamberAppointmentService chamberAppointmentService;
	
	@PostMapping("/chamberappointment/create/{chamberid}")
	public ResponseEntity<ChamberAppointment> createChamberAppoitnment(@RequestBody ChamberAppointment chamberAppointment, @PathVariable String chamberid){
		return new ResponseEntity<>(chamberAppointmentService.createAppointment(chamberAppointment, chamberid), HttpStatus.OK);
	}
	
	@GetMapping("/chamberappointment/getallappointments/{chamberid}")
	public ResponseEntity<List<ChamberAppointment>> getAllChamberAppointments(@PathVariable String chamberid){
		return new ResponseEntity<>(chamberAppointmentService.showAllAppointments(chamberid),HttpStatus.OK);
	}
	
}
