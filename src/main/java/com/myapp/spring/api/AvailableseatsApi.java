package com.myapp.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Flightseats;

import com.myapp.spring.model.FlightAvailable;
import com.myapp.spring.repository.AvailableseatsRepository;

@RestController
@RequestMapping("/api/v1/flightseats")
public class AvailableseatsApi {
	
	@Autowired
	private AvailableseatsRepository repository;
	
	
	@PostMapping
	public ResponseEntity<List<Flightseats>> ProductsInsert
	(@RequestBody List<Flightseats> flights){

	return new ResponseEntity<List<Flightseats>>(repository.saveAll(flights),
	HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Flightseats>> findAll(){

	return new ResponseEntity<List<Flightseats>>(repository.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/availableseatsbyid")
	public ResponseEntity<List<FlightAvailable>> findAvailableSeatsByFlightId
	(@RequestParam Integer flightId){
		
	return new ResponseEntity<>
	(repository.findAvailableSeatsByFlightId(flightId), HttpStatus.OK);
	
	
	
    
	}
	



}