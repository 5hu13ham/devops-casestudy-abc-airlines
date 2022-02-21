package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.model.aircraft;


public interface aircraftrepo extends JpaRepository<aircraft, Integer>{
	
	List<aircraft> findByAircraftTypeAndSchedules(String aircraftType, String schedules);

}
