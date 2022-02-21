package com.myapp.spring.model;

import java.math.BigInteger;
import java.time.LocalDate;

import com.myapp.spring.BookingAvailableDto;


@BookingAvailableDto
public class FlightAvailable {
	private Object flightId;
	private BigInteger availableSeats;

	

	
	public FlightAvailable() {
		// TODO Auto-generated constructor stub
	}



	public FlightAvailable(Object flightId, BigInteger availableSeats) {
		this.flightId = flightId;
		this.availableSeats = availableSeats;
	
	}



	public Object getFlightId() {
		return flightId;
	}



	public void setFlightId(Object flightId) {
		this.flightId = flightId;
	}



	public BigInteger getAvailableSeats() {
		return availableSeats;
	}



	public void setAvailableSeats(BigInteger availableSeats) {
		this.availableSeats = availableSeats;
	}



	
	
}
	