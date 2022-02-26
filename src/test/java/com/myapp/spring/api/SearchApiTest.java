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

import com.myapp.spring.model.Search;
import com.myapp.spring.repository.SearchRepository;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class SearchApiTest {
	
	@MockBean
	private SearchRepository repository;

	@Autowired
	private MockMvc mockMvc;
	
	/*@Test
	@DisplayName("Test All flights /api/v1/flights/")
	public void testGetAllProducts() throws Exception {

	// Prepare Mock Flight
		LocalDate localDate1 =LocalDate.of(2022,02,18);
		Search flight1 = new Search("AirAsia", "Kerala", "Kolkata", 3456.6, 4.5,Date.from(localDate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		flight1.setFlightId(78);

		LocalDate localDate2 =LocalDate.of(2022, 12, 9);
		Search flight2 = new Search("Indigo","Delhi","Bangalore",2345.6,1.45,Date.from(localDate2.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		flight2.setFlightId(35);
		
		
		



		List<Search> flights = new ArrayList<>();
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
	
	.andExpect(jsonPath("$[0].flightId", is(78)))
	.andExpect(jsonPath("$[0].flightName", is("AirAsia")))
	.andExpect(jsonPath("$[0].sourceCity", is("Kerala")))
	.andExpect(jsonPath("$[0].destinationCity", is("Kolkata")))
	.andExpect(jsonPath("$[0].price", is(3456.6)))
	.andExpect(jsonPath("$[0].duration", is(4.5)))
	.andExpect(jsonPath("$[0].date",is("2022-02-17")))
	
	.andExpect(jsonPath("$[1].flightId", is(35)))
	.andExpect(jsonPath("$[1].flightName", is("Indigo")))
	.andExpect(jsonPath("$[1].sourceCity", is("Delhi")))
	.andExpect(jsonPath("$[1].destinationCity", is("Bangalore")))
	.andExpect(jsonPath("$[1].price", is(2345.6)))
	.andExpect(jsonPath("$[1].duration", is(1.45)))
	.andExpect(jsonPath("$[1].date",is("2022-12-08")));


		
		




	}*/

	
	@Test
	@DisplayName("Test Get All Flights By sourceCity,destinationCity,date  /api/v1/flights/SourceCityAndDestinationCityAndDate")
	public void testGetAllFlightsBySourceCityAndDestinationCityAndDate() throws Exception {

	// Prepare Mock Flight
		LocalDate localDate1 =LocalDate.of(2022,02,18);
		Search flight1 = new Search("AirAsia", "Kerala", "Kolkata", 3456.6, 4.5,Date.from(localDate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		flight1.setFlightId(78);

		LocalDate localDate2 =LocalDate.of(2022, 12, 9);
		Search flight2 = new Search("Indigo","Delhi","Bangalore",2345.6,1.45,Date.from(localDate2.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		flight2.setFlightId(35);
		
		
		


	List<Search> flights = new ArrayList<>();
	flights.add(flight1);
	flights.add(flight2);


	// Prepare Mock Service Method
	String sourceCity="Delhi";
	String destinationCity="Bangalore";
	LocalDate localDate= LocalDate.of(2022,12,9);
	

	doReturn(flights).when(repository)
	.findBySourceCityAndDestinationCityAndDate(sourceCity,destinationCity,Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));


	// Perform GET Request


	mockMvc.perform(MockMvcRequestBuilders
	.get("/api/v1/flights/SourceCityAndDestinationCityAndDate")
	.queryParam("sourceCity",sourceCity)
	.queryParam("destinationCity", destinationCity)
	.queryParam("date",localDate.toString()))
	// Validate Status should be 200 OK and JSON response received
	.andExpect(status().isOk())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

	// Validate Response Body
	.andExpect(jsonPath("$[0].flightId", is(78)))
	.andExpect(jsonPath("$[0].flightName", is("AirAsia")))
	.andExpect(jsonPath("$[0].sourceCity", is("Kerala")))
	.andExpect(jsonPath("$[0].destinationCity", is("Kolkata")))
	.andExpect(jsonPath("$[0].price", is(3456.6)))
	.andExpect(jsonPath("$[0].duration", is(4.5)))
	.andExpect(jsonPath("$[0].date",is("2022-02-17")))
	
	.andExpect(jsonPath("$[1].flightId", is(35)))
	.andExpect(jsonPath("$[1].flightName", is("Indigo")))
	.andExpect(jsonPath("$[1].sourceCity", is("Delhi")))
	.andExpect(jsonPath("$[1].destinationCity", is("Bangalore")))
	.andExpect(jsonPath("$[1].price", is(2345.6)))
	.andExpect(jsonPath("$[1].duration", is(1.45)))
	.andExpect(jsonPath("$[1].date",is("2022-12-08")));








	}
	
}
