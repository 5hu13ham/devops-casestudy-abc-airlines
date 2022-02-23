package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.model.Aircraft;


public interface AircraftRepo extends JpaRepository<Aircraft, Integer>{
	
	List<Aircraft> findByAircraftTypeAndSchedules(String aircraftType, String schedules);

}
