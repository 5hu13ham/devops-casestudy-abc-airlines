package com.myapp.spring.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

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
import com.myapp.spring.model.Flight;

@SpringBootTest
public class FlightRepositoryTest {


@Autowired
private FlightRepository repository;

private static File DATA_JSON= Paths.get("src","test","resources","flights.json").toFile();


@BeforeEach
public void setUp() throws JsonParseException, JsonMappingException, IOException {

Flight flights[]=new ObjectMapper().readValue(DATA_JSON, Flight[].class);

// save each product to database
Arrays.stream(flights).forEach(repository::save);


}

/*@AfterEach
public void cleanUp() {
repository.deleteAll();

}*/

@Test
@DisplayName("Test flight not found for a non existing id")
public void flighttNotFoundForNonExistingId() {

// given three products in the database

// when we retrieve a product using non existing id
Flight flight=repository.findById(100).orElseGet(()-> new Flight());

// Then perform Assert Conditions To validate
Assertions.assertNull(flight.getFlightId(),
"Product With Id 100 should not exist");

}
/*@Test
@DisplayName("Test Search Flights Successfully")
public void testSearchFlightsSuccessfully()
{
	Flight flight = new Flight("AirAsia","Chennai","Kochi",2782.00,2.75);
	
	Assertions.assertEquals(flight.getDestinationCity())
}*/
}