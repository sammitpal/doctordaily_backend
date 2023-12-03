package com.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.model.Chamber;

public interface ChamberRepository extends JpaRepository<Chamber, String>{


}
