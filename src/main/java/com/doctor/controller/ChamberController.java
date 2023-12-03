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

import com.doctor.model.Chamber;
import com.doctor.model.service.ChamberService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ChamberController {

	@Autowired
	ChamberService chamberService;
	
	@PostMapping("/chamber/create/{username}")
	private ResponseEntity<?> createChamber(@RequestBody Chamber chamber, @PathVariable String username){
		return new ResponseEntity<>(chamberService.createChamber(chamber,username),HttpStatus.OK);
	}
	@GetMapping("/chamber/getchamber/{username}")
	private ResponseEntity<?> getChamber(@PathVariable String username){
		return new ResponseEntity<>(chamberService.getChamber(username),HttpStatus.OK);
	}
	
}
