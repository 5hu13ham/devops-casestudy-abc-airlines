package com.myapp.spring.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Aircraft;
import com.myapp.spring.repository.AircraftRepo;


@SpringBootTest
public class AircraftRepositoryTest {
	
	@Autowired
	private AircraftRepo repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","aircrafttest.json").toFile();
	
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
	Aircraft aircrafts[]=new ObjectMapper().readValue(DATA_JSON, Aircraft[].class);
	
	// save each product to database
	Arrays.stream(aircrafts).forEach(repository::save);	
		
		
	}
	
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}
	
	@Test
	@DisplayName("Test aircraft not found for a non existing id")
	public void testAircraftNotFoundForNonExistingId() {
		
		// given two aircraft in the database
		
		// when we retrieve an aircraft using non existing id
		Aircraft aircrafts=( repository.findById(100)).orElseGet(()-> new Aircraft());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(aircrafts.getFlightId(), 
				"this aircraft does not exist");
		
		}
	
	
	@Test
	@DisplayName("Test aircraft saved sucessfully")
	public void testAircraftSavedSucessfully() {
		
		// given a mock aircraft
		LocalDate localdate1 = LocalDate.of(2022,02,26);
		Aircraft aircrafts = new Aircraft("6E537","Bangalore","Kolkata",3500.0,2.5,"Indigo","2022-02-26 7:15 pm",150,25,125,Date.from(localdate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		
		// when we retrieve an aircraft using non existing id
		Aircraft newaircrafts=repository.save(aircrafts);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(newaircrafts, 
				"New aircraft should be saved");
		
		Assertions.assertNotNull(newaircrafts.getFlightId(), 
				"New Aircraft should have id");
		Assertions.assertEquals(aircrafts.getFlightName(), 
				newaircrafts.getFlightName());
		
		
		}
	
	/*@Test
	@DisplayName("Test product updated successfully")
	public void testProductUpdatedSucessfully() {
		
		// given a mock aircraft
		LocalDate localdate1 = LocalDate.of(2022,02,25);
		aircraft aircrafts = new aircraft(1,"6E535","Bangalore","Kolkata",3500.0,2.5,"Indigo","2022-02-25 6:15 pm",150,25,125,localdate1);
		
		// when we retrieve a aircraft using non existing id
		aircraft newaircraft=repository.save(aircrafts);
		
		
		Assertions.assertEquals(aircrafts.getPrice(), 
				newaircraft.getPrice());
		
		
		}*/
	

}