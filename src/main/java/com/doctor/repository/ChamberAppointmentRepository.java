package com.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.model.Chamber;
import com.doctor.model.ChamberAppointment;

public interface ChamberAppointmentRepository extends JpaRepository<ChamberAppointment, String>{

	List<ChamberAppointment> findByChamber(Chamber foundChamber);


}
