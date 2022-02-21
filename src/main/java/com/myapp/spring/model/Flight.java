package com.myapp.spring.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table(name = "abcflights")
public class Flight {
	@Id
	@Column(name = "flight_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer flightId;
	
	@Column(name = "flight_name",nullable = false)
	private String flightName;
	
	
	@Column(name = "departure_date",nullable = false)
	//@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name = "total_seats",nullable = false)
	private Integer totalSeats;
	
	@Column(name = "booked_seats",nullable = false)
	private Integer bookedSeats;
	
	@Column(name = "available_seats",nullable = false)
	private Integer availableSeats;

	public Flight() {
		
		// TODO Auto-generated constructor stub
	}

	public Flight(Integer flightId, String flightName, LocalDate date, Integer totalSeats, Integer bookedSeats,
			Integer availableSeats) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.date = date;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
		this.availableSeats = availableSeats;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Integer bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableSeats, bookedSeats, date, flightId, flightName, totalSeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Flight))
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(availableSeats, other.availableSeats) && Objects.equals(bookedSeats, other.bookedSeats)
				&& Objects.equals(date, other.date) && Objects.equals(flightId, other.flightId)
				&& Objects.equals(flightName, other.flightName) && Objects.equals(totalSeats, other.totalSeats);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [flightId=");
		builder.append(flightId);
		builder.append(", flightName=");
		builder.append(flightName);
		builder.append(", date=");
		builder.append(date);
		builder.append(", totalSeats=");
		builder.append(totalSeats);
		builder.append(", bookedSeats=");
		builder.append(bookedSeats);
		builder.append(", availableSeats=");
		builder.append(availableSeats);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
	