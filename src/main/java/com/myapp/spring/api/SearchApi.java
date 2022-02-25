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

import com.myapp.spring.model.Search;
import com.myapp.spring.repository.SearchRepository;

@RestController
@RequestMapping("/api/v1/flights")
public class SearchApi {
	
	@Autowired
	private SearchRepository repository;
	
	/*@GetMapping
	public ResponseEntity<List<Search>> findAll(){

	return new ResponseEntity<List<Search>>(repository.findAll(), HttpStatus.OK);
	}*/
	
	@GetMapping("/SourceCityAndDestinationCityAndDate")
	public ResponseEntity<List<Search>> findBySourceCityAndDestinationCityAndDate
	(@RequestParam("sourceCity") String sourceCity,
	@RequestParam("destinationCity") String destinationCity,
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@RequestParam("date") Date date
	){
	return new ResponseEntity<List<Search>>
	(repository.findBySourceCityAndDestinationCityAndDate(sourceCity,destinationCity,date), HttpStatus.OK);
	}
	
	

	


}
