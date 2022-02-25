package com.myapp.spring.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Price;
import com.myapp.spring.repository.PriceRepository;


@RestController
@RequestMapping("/api/v1/flights")
public class PriceApi {
	
	@Autowired
	private PriceRepository repository;
	
	/*@GetMapping
	public ResponseEntity<List<Price>> findAll(){

	return new ResponseEntity<List<Price>>(repository.findAll(), HttpStatus.OK);
	}*/
	
/*	@GetMapping("/SourceCityandDestinationCity/{sourceCity}/{destinationCity}")
	public ResponseEntity<List<Flight>> findBySourceCityAndDestinationCity
	(@RequestParam String sourceCity,
	@RequestParam String destinationCity){
	return new ResponseEntity<List<Flight>>
	(repository.findBySourceCityAndDestinationCity(sourceCity,destinationCity), HttpStatus.OK);
	}
	*/
	
	@GetMapping("/findByFlightNameAndDate")
    public ResponseEntity<List<Price>> findByFlightNameAndDate
    (@RequestParam("flightName") String flightName,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @RequestParam("date") Date date
    ){
    return new ResponseEntity<List<Price>>
    (repository.findByFlightNameAndDate(flightName,date), HttpStatus.OK);
    }
	


}
