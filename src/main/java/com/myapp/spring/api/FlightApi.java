package com.myapp.spring.api;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Flight;

import com.myapp.spring.repository.FlightRepository;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightApi {
	
	@Autowired
	private FlightRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Flight>> findAll(){

	return new ResponseEntity<List<Flight>>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/SourceCityandDestinationCity")
	public ResponseEntity<List<Flight>> findBySourceCityAndDestinationCity
	(@RequestParam("sourceCity") String sourceCity,
	@RequestParam("destinationCity") String destinationCity
	){
	return new ResponseEntity<List<Flight>>
	(repository.findBySourceCityAndDestinationCity(sourceCity,destinationCity), HttpStatus.OK);
	}
	
	/*@GetMapping("/findPriceBySourceCityandDestinationCity")
	public ResponseEntity<List<NFlight>> findPriceBySourceCityandDestinationCity
	(@RequestParam("sourceCity") String sourceCity,
	@RequestParam("destinationCity") String destinationCity
	){
	return new ResponseEntity<List<NFlight>>
	(repository.findPriceBySourceCityandDestinationCity(sourceCity,destinationCity), HttpStatus.OK);
	}*/
	
	


}
