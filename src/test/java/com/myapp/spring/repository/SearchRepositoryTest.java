package com.myapp.spring.repository;

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
import com.myapp.spring.model.Search;


@SpringBootTest
public class SearchRepositoryTest {

//@ImportAutoConfiguration(JacksonAutoConfiguration.class)
@Autowired

private SearchRepository repository;

private static File DATA_JSON= Paths.get("src","test","resources","search.json").toFile();


@BeforeEach
public void setUp() throws JsonParseException, JsonMappingException, IOException {

	
Search flights[]=new ObjectMapper().readValue(DATA_JSON, Search[].class);

// save each product to database
Arrays.stream(flights).forEach(repository::save);


}
@AfterEach
public void cleanUp() {
repository.deleteAll();

}
/*@Test
@DisplayName("Test flight not found for a non existing id")
public void flightNotFoundForNonExistingId() {

// given three products in the database

// when we retrieve a product using non existing id
Search flight=repository.findById(100).orElseGet(()-> new Search());

// Then perform Assert Conditions To validate
Assertions.assertNull(flight.getFlightId(),
"Product With Id 100 should not exist");

}*/


@Test
@DisplayName("Test flight saved sucessfully")
public void testFlightSavedSucessfully() {

// given a mock product
LocalDate localDate =LocalDate.of(2022, 11, 9);
Search flight = new Search("AirIndia","Mumbai","Delhi",3567.8,2.75,Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
flight.setFlightId(95);

// when we retrieve a flight using non existing id
Search savedFlight=repository.save(flight);

// Then perform Assert Conditions To validate
Assertions.assertNotNull(savedFlight,
"New Flight should be saved");

Assertions.assertNotNull(savedFlight.getFlightId(),
"New Flight should have id");
Assertions.assertEquals(flight.getFlightName(),
savedFlight.getFlightName());


}







}