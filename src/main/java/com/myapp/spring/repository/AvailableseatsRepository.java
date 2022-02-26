package com.myapp.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.spring.model.Flightseats;
import com.myapp.spring.model.FlightAvailable;



public interface AvailableseatsRepository extends JpaRepository<Flightseats, Integer>{
	
	
	
	
	@Query(value="select flight_id as flightId ,total_seats-booked_seats  as availableSeats From abcflightseats where flight_id = ?1 ",nativeQuery=true)
	List<FlightAvailable> findAvailableSeatsByFlightId(Integer flightId);
	
	
	
	
	
	

}

