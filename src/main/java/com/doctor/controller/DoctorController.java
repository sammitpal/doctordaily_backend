package com.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.model.Doctor;
import com.doctor.model.service.DoctorService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/doctor/saveinfo")
	public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<>(doctorService.savedDoctor(doctor), HttpStatus.OK);
	}
	@GetMapping("/doctor/getinfo/{username}")
	public ResponseEntity<?> getDoctor(@PathVariable String username){
		return new ResponseEntity<>(doctorService.getDoctorData(username), HttpStatus.OK);
	}

}
