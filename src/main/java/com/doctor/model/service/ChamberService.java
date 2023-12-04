package com.doctor.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.model.Chamber;
@Service
public interface ChamberService {

	public Chamber createChamber(Chamber chamber, String username);
	public List<Chamber> getChamber(String username);
	
}
