
package com.myapp.spring.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.aircraft;
import com.myapp.spring.repository.aircraftrepo;

@RestController
@RequestMapping("/api/v1/flights")
public class aircraftapi {
	
	@Autowired
	private aircraftrepo repository;
	
	@GetMapping
	public ResponseEntity<List<aircraft>> findAll(){

	return new ResponseEntity<List<aircraft>>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/findByAircraftTypeandSchedules")
	public ResponseEntity<List<aircraft>> findByAircraftTypeAndSchedules
	(@RequestParam("aircraftType") String aircraftType,
	@RequestParam("schedules") String schedules){
	return new ResponseEntity<List<aircraft>>
	(repository.findByAircraftTypeAndSchedules(aircraftType,schedules), HttpStatus.OK);
	}
}
