

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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.spring.model.Aircraft;
import com.myapp.spring.repository.AircraftRepo;


@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class AircraftApiTest {
	
	@MockBean
	private AircraftRepo repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	/*@Test
	@DisplayName("Test aircrafts by AircraftType and Schedules - GET /api/v1/flights/findByAircraftTypeAndSchedules")
	public void testGetProductsById() throws Exception {
		
		// Prepare Mock Product
		aircraft aircraft1 = new aircraft(1,"6E535","Bangalore","Kolkata",3500.00,2.5,"Indigo","2022-02-25 6:15 pm",150,25,125);
		aircraft1.setFlightId(2);
		
		List<aircraft> aircrafts = new ArrayList<>();
		aircrafts.add(aircraft1);
		
		// Prepare Mock Service Method
		
		doReturn(aircrafts).when(repository).findByAircraftTypeAndSchedules(aircraft1.getAircraftType(),aircraft1.getSchedules());
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights/findByAircraftTypeAndSchedules").queryParam(null, null))
		
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		
		
		.andExpect(jsonPath("$.flightId", is(1)))
		.andExpect(jsonPath("$.flightName", is("6E535")))
		.andExpect(jsonPath("$.sourceCity",is("Bangalore")))
		.andExpect(jsonPath("$.destinationCity", is("Kolkata")))
		.andExpect(jsonPath("$.price", is(3500.00)))
		.andExpect(jsonPath("$.duration", is(2.5)))
		.andExpect(jsonPath("$.aircraftType",is("Indigo")))
		.andExpect(jsonPath("$.schedules",is("2022-02-25 6:15 pm")))
		.andExpect(jsonPath("$.totalSeats",is(150)))
		.andExpect(jsonPath("$.bookedSeats",is(25)))
		.andExpect(jsonPath("$.availableSeats",is(125)));
				
		
	}*/
	
	@Test
	@DisplayName("Test All Products /api/v1/flights/findByAircraftTypeAndSchedules")
	public void testGetAllProducts() throws Exception {
		
		// Prepare Mock Product
		LocalDate localdate1 = LocalDate.of(2022, 02,25);
		Aircraft aircraft1 = new Aircraft("6E535","Bangalore","Kolkata",3500.0,2.5,"Indigo","2022-02-25 6:15 pm",150,25,125, Date.from(localdate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		aircraft1.setFlightId(35);
		
		LocalDate localdate2 = LocalDate.of(2022, 02,25);
		Aircraft aircraft2 = new Aircraft("6E534","Bangalore","Kolkata",3500.0,2.5,"Indigo","2022-02-25 6:16 pm",150,25,125,Date.from(localdate2.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		aircraft2.setFlightId(36);
		
		List<Aircraft> aircrafts = new ArrayList<>();
		aircrafts.add(aircraft1);
		aircrafts.add(aircraft2);
		
		// Prepare Mock Service Method
		String aircraftType = "Indigo";
		String schedules = "2022-02-25 6:15 pm";
		doReturn(aircrafts).when(repository).findByAircraftTypeAndSchedules(aircraftType,schedules);
		
		// Perform GET Request
		
		
				mockMvc.perform(MockMvcRequestBuilders
						.get("/api/v1/flights/findByAircraftTypeAndSchedules")
						.queryParam("aircraftType",aircraftType)
						.queryParam("schedules", schedules))
				// Validate Status should be 200 OK and JSON response received
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].flightId", is(35)))
		.andExpect(jsonPath("$[0].flightName", is("6E535")))
		.andExpect(jsonPath("$[0].sourceCity",is("Bangalore")))
		.andExpect(jsonPath("$[0].destinationCity", is("Kolkata")))
		.andExpect(jsonPath("$[0].price", is(3500.00)))
		.andExpect(jsonPath("$[0].duration", is(2.5)))
		.andExpect(jsonPath("$[0].aircraftType",is("Indigo")))
		.andExpect(jsonPath("$[0].schedules",is("2022-02-25 6:15 pm")))
		.andExpect(jsonPath("$[0].totalSeats",is(150)))
		.andExpect(jsonPath("$[0].bookedSeats",is(25)))
		.andExpect(jsonPath("$[0].availableSeats",is(125)))
		.andExpect(jsonPath("$[0].date",is("2022-02-24")))
		
		.andExpect(jsonPath("$[1].flightId", is(36)))
		.andExpect(jsonPath("$[1].flightName", is("6E534")))
		.andExpect(jsonPath("$[1].sourceCity",is("Bangalore")))
		.andExpect(jsonPath("$[1].destinationCity", is("Kolkata")))
		.andExpect(jsonPath("$[1].price", is(3500.00)))
		.andExpect(jsonPath("$[1].duration", is(2.5)))
		.andExpect(jsonPath("$[1].aircraftType",is("Indigo")))
		.andExpect(jsonPath("$[1].schedules",is("2022-02-25 6:16 pm")))
		.andExpect(jsonPath("$[1].totalSeats",is(150)))
		.andExpect(jsonPath("$[1].bookedSeats",is(25)))
		.andExpect(jsonPath("$[1].availableSeats",is(125)))
		.andExpect(jsonPath("$[1].date",is("2022-02-24")));
		
		
		
	}
	
	/*@Test
	@DisplayName("Test All Products By Price /api/v1/products/{price}")
	public void testGetAllProductsByPrice() throws Exception {
		
		// Prepare Mock Product
		Product product1 = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		product1.setProductId(35);
		
		Product product2 = new Product("Oneplus", "OnePlus8Pro", 60000.00, 4.5);
		product2.setProductId(36);
		
		Product product3 = new Product("Iphone", "Iphone12", 80000.00, 4.5);
		product3.setProductId(37);
		
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		// Prepare Mock Service Method
		double price =50000.00;
		
		doReturn(Optional.of(products)).when(repository)
		.findByPriceGreaterThanEqual(price);
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/findByPrice/{price}",price))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].productId", is(35)))
		.andExpect(jsonPath("$[0].productName", is("Oneplus")))
		.andExpect(jsonPath("$[0].description", is("OnePlus9Pro")))
		.andExpect(jsonPath("$[0].price", is(70000.00)))
		.andExpect(jsonPath("$[0].starRating", is(4.5)))
		
		.andExpect(jsonPath("$[1].productId", is(36)))
		.andExpect(jsonPath("$[1].productName", is("Oneplus")))
		.andExpect(jsonPath("$[1].description", is("OnePlus8Pro")))
		.andExpect(jsonPath("$[1].price", is(60000.00)))
		.andExpect(jsonPath("$[1].starRating", is(4.5)))
		
		.andExpect(jsonPath("$[2].productId", is(37)))
		.andExpect(jsonPath("$[2].productName", is("Iphone")))
		.andExpect(jsonPath("$[2].description", is("Iphone12")))
		.andExpect(jsonPath("$[2].price", is(80000.00)))
		.andExpect(jsonPath("$[2].starRating", is(4.5)));
		
		
	}
	
	@Test
	@DisplayName("Test All Products By Price /api/v1/products?name=&price")
	public void testGetAllProductsByNameOrPrice() throws Exception {
		
		// Prepare Mock Product
		Product product1 = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		product1.setProductId(35);
		
		Product product2 = new Product("Oneplus", "OnePlus8Pro", 60000.00, 4.5);
		product2.setProductId(36);
		
		
		
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		
		
		// Prepare Mock Service Method
		Double price =50000.00;
		String productName="Oneplus";
		
		doReturn(Optional.of(products)).when(repository)
		.findByProductNameOrPrice(productName, price);
		
		
		// Perform GET Request
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/products/findByPriceOrName")
				.queryParam("productName",productName)
				.queryParam("price", price.toString()))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].productId", is(35)))
		.andExpect(jsonPath("$[0].productName", is("Oneplus")))
		.andExpect(jsonPath("$[0].description", is("OnePlus9Pro")))
		.andExpect(jsonPath("$[0].price", is(70000.00)))
		.andExpect(jsonPath("$[0].starRating", is(4.5)))
		
		.andExpect(jsonPath("$[1].productId", is(36)))
		.andExpect(jsonPath("$[1].productName", is("Oneplus")))
		.andExpect(jsonPath("$[1].description", is("OnePlus8Pro")))
		.andExpect(jsonPath("$[1].price", is(60000.00)))
		.andExpect(jsonPath("$[1].starRating", is(4.5)));
		
		
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Test Add New Product")
	public void testAddNewProduct() throws Exception {
		
		// Prepare Mock Product
		Product newproduct = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		
		Product mockproduct = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		mockproduct.setProductId(50);
		// Prepare Mock Service Method
		
		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(post("/api/v1/products")
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(newproduct)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.productId", is(50)))
		.andExpect(jsonPath("$.productName", is("Oneplus")))
		.andExpect(jsonPath("$.description", is("OnePlus9Pro")))
		.andExpect(jsonPath("$.price", is(70000.00)))
		.andExpect(jsonPath("$.starRating", is(4.5)));
		
		
	}
	@Test
	@DisplayName("Test Update Existing Product")
	public void testUpdateExistingProduct() throws Exception {
		
		// Prepare Mock Product
		
		Product mockproduct = new Product("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		
		Product productToBeUpdated = new Product("Oneplus", "OnePlus10Pro", 70000.00, 4.5);
		productToBeUpdated.setProductId(50);
		
		
		mockproduct.setProductId(50);
		// Prepare Mock Service Method
		
		doReturn(Optional.of(mockproduct)).when(repository).findById(50);
		
		doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(put("/api/v1/products/{id}",50)
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(productToBeUpdated)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.productId", is(50)))
		.andExpect(jsonPath("$.productName", is("Oneplus")))
		.andExpect(jsonPath("$.description", is("OnePlus10Pro")))
		.andExpect(jsonPath("$.price", is(70000.00)))
		.andExpect(jsonPath("$.starRating", is(4.5)));
		
		
	}*/
	

}