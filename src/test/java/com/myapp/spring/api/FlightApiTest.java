package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.spring.model.Flight;

import com.myapp.spring.repository.FlightRepository;



@AutoConfigureMockMvc(addFilters = false)
public class FlightApiTest {
	
	@MockBean
	private FlightRepository repository;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test All Products /api/v1/flights/")
	public void testGetAllProducts() throws Exception {

	// Prepare Mock Flight
		Flight flight1 = new Flight("AirAsia","Chennai","Kochi",2782.00,2.75);
		flight1.setFlightId(35);

		Flight flight2 = new Flight("Indigo","Bangalore","Mumbai",2201.00,1.45);
		flight2.setFlightId(78);



		List<Flight> flights = new ArrayList<>();
		flights.add(flight1);
		flights.add(flight2);


	// Prepare Mock Service Method

		doReturn(flights).when(repository).findAll();

	// Perform GET Request

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights"))
	// Validate Status should be 200 OK and JSON response received
	.andExpect(status().isOk())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	// Validate Response Body

		.andExpect(jsonPath("$[0].flightId", is(35)))
		.andExpect(jsonPath("$[0].flightName", is("Indigo")))
		.andExpect(jsonPath("$[0].sourceCity", is("Bangalore")))
		.andExpect(jsonPath("$[0].destinationCity", is("Mumbai")))
		.andExpect(jsonPath("$[0].price", is(2782.00)))
		.andExpect(jsonPath("$[0].duration", is(1.45)))
		//.andExpect(jsonPath("$[0].date",is(2022-12-09)))

		.andExpect(jsonPath("$[0].flightId", is(36)))
		.andExpect(jsonPath("$[0].flightName", is("AirAsia")))
		.andExpect(jsonPath("$[0].sourceCity", is("Chennai")))
		.andExpect(jsonPath("$[0].destinationCity", is("Kochi")))
		.andExpect(jsonPath("$[0].price", is(2782.00)))
		.andExpect(jsonPath("$[0].duration", is(2.75)));
		//.andExpect(jsonPath("$[0].date",is(2022-02-18))));




	}

	
	@Test
	@DisplayName("Test GET All Flights By sourceCity,destinationCity  /api/v1/flights/SourceCityAndDestinationCity")
	public void testGetAllFlightsBySourceCityAndDestinationCity() throws Exception {

	// Prepare Mock Flight
	Flight flight1 = new Flight("AirAsia","Chennai","Kochi",2782.00,2.75);
	//flight1.setFlightId(35);

	Flight flight2 = new Flight("Indigo","Bangalore","Mumbai",2201.00,1.45);
	//flight2.setFlightId(78);



	List<Flight> flights = new ArrayList<>();
	flights.add(flight1);
	flights.add(flight2);


	// Prepare Mock Service Method
	String sourceCity="Chennai";
	String destinationCity="Kochi";
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//LocalDate date=2022-02-18;

	doReturn(flights).when(repository)
	.findBySourceCityAndDestinationCity(sourceCity,destinationCity);


	// Perform GET Request


	mockMvc.perform(MockMvcRequestBuilders
	.get("/api/v1/flights/SourceCityAndDestinationCity")
	.queryParam("sourceCity",sourceCity)
	.queryParam("destinationCity", destinationCity))
	//.queryParam("date",date.toString())
	// Validate Status should be 200 OK and JSON response received
	.andExpect(status().isOk())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

	// Validate Response Body

	.andExpect(jsonPath("$[0].flightId", is(35)))
	.andExpect(jsonPath("$[0].flightName", is("Indigo")))
	.andExpect(jsonPath("$[0].sourceCity", is("Bangalore")))
	.andExpect(jsonPath("$[0].destinationCity", is("Mumbai")))
	.andExpect(jsonPath("$[0].price", is(2782.00)))
	.andExpect(jsonPath("$[0].duration", is(1.45)))
	//.andExpect(jsonPath("$[0].date",is(2022-12-09)))

	.andExpect(jsonPath("$[0].flightId", is(36)))
	.andExpect(jsonPath("$[0].flightName", is("AirAsia")))
	.andExpect(jsonPath("$[0].sourceCity", is("Chennai")))
	.andExpect(jsonPath("$[0].destinationCity", is("Kochi")))
	.andExpect(jsonPath("$[0].price", is(2782.00)))
	.andExpect(jsonPath("$[0].duration", is(2.75)));
	//.andExpect(jsonPath("$[0].date",is(2022-02-18))));







	}
}
