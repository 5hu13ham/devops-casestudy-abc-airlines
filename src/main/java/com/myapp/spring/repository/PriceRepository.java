package com.myapp.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.model.Price;

public interface PriceRepository extends JpaRepository<Price, Integer>{
    
    
   List<Price> findByFlightNameAndDate(String flightName,Date date);
   //@Query(value="select price FROM devopsflights where source_city=?1 and destination_city=?2",nativeQuery=true)
  //  List<Flight> findPriceBySourceCityandDestinationCity(String sourceCity,String destinationCity);
   // @Query("select new com.myapp.spring.model.FlightDto(f.flightId,f.price) From Flight f where sourceCity=?1 and destinationCity=?2 and date")
   // List<FlightDto> findPriceByFlightId(Integer flightId);
	
}
