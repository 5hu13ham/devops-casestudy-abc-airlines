package com.myapp.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.myapp.spring.model.Flight;



public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	
	List<Flight> findBySourceCityAndDestinationCity(String sourceCity,String destinationCity);
	//@Query(value="select price FROM abc_airlines where source_city=?1 and destination_city=?2",nativeQuery=true)
	//List<NFlight> findPriceBySourceCityandDestinationCity(String sourceCity,String destinationCity);

}
