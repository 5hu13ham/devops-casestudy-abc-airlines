package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.spring.model.Flightseats;
import com.myapp.spring.repository.AvailableseatsRepository;




@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AvailableseatsApiTest {
	
	@MockBean
	private AvailableseatsRepository repository;

	@Autowired
	private MockMvc mockMvc;
	
	/*@Test
	@DisplayName("Test All Flights /api/v1/flights/")
	public void testGetAllFlights() throws Exception {

	// Prepare Mock Flight
		LocalDate localDate =LocalDate.of(2022,02,22);
		Flight flight1 = new Flight("INDIGO", localDate, 150, 75, 75);
		flight1.setFlightId(242);

		LocalDate localDate2 =LocalDate.of(2022,03,12);
		Flight flight2 = new Flight("SpiceJet", localDate2, 135, 100, 35);
		flight2.setFlightId(243);
		
		
		



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
	
	.andExpect(status().isCreated())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	.andExpect(jsonPath("$[0].flightId", is(242)))
	.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
	.andExpect(jsonPath("$[0].date", is("2022-02-22")))
	.andExpect(jsonPath("$[0].totalSeats", is(150)))
	.andExpect(jsonPath("$[0].bookedSeats", is(75)))
	.andExpect(jsonPath("$[0].availableSeats", is(75)))
	
	.andExpect(jsonPath("$[1].flightId", is(243)))
	.andExpect(jsonPath("$[1].flightName", is("SpiceJet")))
	.andExpect(jsonPath("$[1].date", is("2022-03-12")))
	.andExpect(jsonPath("$[1].totalSeats", is(135)))
	.andExpect(jsonPath("$[1].bookedSeats", is(100)))
	.andExpect(jsonPath("$[1].availableSeats", is(35)));


		
		




	}*/

	
	@Test
	@DisplayName("Test Get AvailableSeats By FlightId  /api/v1/flightseats/availableseatsbyid")
	public void testGetAvailableByFlightId() throws Exception {

	// Prepare Mock Flight
		LocalDate localDate =LocalDate.of(2022,02,23);
		Flightseats flight1 = new Flightseats( "INDIGO", Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 150, 75, 75);
		flight1.setFlightId(244);

		LocalDate localDate2 =LocalDate.of(2022,03,13);
		Flightseats flight2 = new Flightseats("SpiceJet", Date.from(localDate2.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 135, 100, 35);
		flight2.setFlightId(245);
		


	List<Flightseats> flights = new ArrayList<>();
	flights.add(flight1);
	flights.add(flight2);


	// Prepare Mock Service Method
	Integer flightId = 244;
	

	doReturn(flights).when(repository)
	.findAvailableSeatsByFlightId(flightId);


	// Perform GET Request


	mockMvc.perform(MockMvcRequestBuilders
	.get("/api/v1/flightseats/availableseatsbyid")
	
	.queryParam("flightId",flightId.toString()))
	// Validate Status should be 200 OK and JSON response received
	.andExpect(status().isOk())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

	// Validate Response Body
	.andExpect(jsonPath("$[0].flightId", is(244)))
	.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
	.andExpect(jsonPath("$[0].date", is("2022-02-22")))
	.andExpect(jsonPath("$[0].totalSeats", is(150)))
	.andExpect(jsonPath("$[0].bookedSeats", is(75)))
	.andExpect(jsonPath("$[0].availableSeats", is(75)))
	
	.andExpect(jsonPath("$[1].flightId", is(245)))
	.andExpect(jsonPath("$[1].flightName", is("SpiceJet")))
	.andExpect(jsonPath("$[1].date", is("2022-03-12")))
	.andExpect(jsonPath("$[1].totalSeats", is(135)))
	.andExpect(jsonPath("$[1].bookedSeats", is(100)))
	.andExpect(jsonPath("$[1].availableSeats", is(35)));








	}

}
