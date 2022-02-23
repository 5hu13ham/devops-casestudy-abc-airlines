
package com.myapp.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Aircraft;
import com.myapp.spring.repository.AircraftRepo;

@RestController
@RequestMapping("/api/v1/flights")
public class AircraftApi {
	
	@Autowired
	private AircraftRepo repository;
	
	@GetMapping
	public ResponseEntity<List<Aircraft>> findAll(){

	return new ResponseEntity<List<Aircraft>>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/findByAircraftTypeAndSchedules")
	public ResponseEntity<List<Aircraft>> findByAircraftTypeAndSchedules
	(@RequestParam("aircraftType") String aircraftType,
	@RequestParam("schedules") String schedules){
	return new ResponseEntity<List<Aircraft>>
	(repository.findByAircraftTypeAndSchedules(aircraftType,schedules), HttpStatus.OK);
	}
}
