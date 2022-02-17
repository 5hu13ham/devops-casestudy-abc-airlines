package com.myapp.spring.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devopsflights")
public class aircraft {
	@Id
	@Column(name = "flight_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer flightId;
	
	@Column(name = "flight_name",nullable = false)
	private String flightName;
	
	@Column(name = "source_city",nullable = false)
	private String sourceCity;
	
	@Column(name = "destination_city",nullable = false)
	private String destinationCity;
	
	@Column(name = "price",nullable = false)
	private Double price;
	
	@Column(name = "duration",nullable = false)
	private Double duration;
	
	@Column(name = "aircraftType", nullable = false)
	private String aircraftType;

	@Column(name = "schedules", nullable = false)
	private String schedules;
	
	@Column(name = "total_seats", nullable = false)
	private String totalSeats;
	
	@Column(name = "booked_seats", nullable = false)
	private String bookedSeats;
	
	@Column(name = "available_seats", nullable = false)
	private String availableSeats;
	
	@Column(name = "departure_date", nullable = false)
	private LocalDate date ;
	
	
	
	public aircraft() {
		
		// TODO Auto-generated constructor stub
	}

	public aircraft(Integer flightId, String flightName, String sourceCity, String destinationCity, Double price,
			Double duration, String aircraftType, String schedules, String totalSeats, String bookedSeats,
			String availableSeats, LocalDate date) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.price = price;
		this.duration = duration;
		this.aircraftType = aircraftType;
		this.schedules = schedules;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
		this.availableSeats = availableSeats;
		this.date = date;
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

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public String getSchedules() {
		return schedules;
	}

	public void setSchedules(String schedules) {
		this.schedules = schedules;
	}

	public String getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aircraftType, availableSeats, bookedSeats, date, destinationCity, duration, flightId,
				flightName, price, schedules, sourceCity, totalSeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof aircraft))
			return false;
		aircraft other = (aircraft) obj;
		return Objects.equals(aircraftType, other.aircraftType) && Objects.equals(availableSeats, other.availableSeats)
				&& Objects.equals(bookedSeats, other.bookedSeats) && Objects.equals(date, other.date)
				&& Objects.equals(destinationCity, other.destinationCity) && Objects.equals(duration, other.duration)
				&& Objects.equals(flightId, other.flightId) && Objects.equals(flightName, other.flightName)
				&& Objects.equals(price, other.price) && Objects.equals(schedules, other.schedules)
				&& Objects.equals(sourceCity, other.sourceCity) && Objects.equals(totalSeats, other.totalSeats);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("aircraft [flightId=");
		builder.append(flightId);
		builder.append(", flightName=");
		builder.append(flightName);
		builder.append(", sourceCity=");
		builder.append(sourceCity);
		builder.append(", destinationCity=");
		builder.append(destinationCity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", aircraftType=");
		builder.append(aircraftType);
		builder.append(", schedules=");
		builder.append(schedules);
		builder.append(", totalSeats=");
		builder.append(totalSeats);
		builder.append(", bookedSeats=");
		builder.append(bookedSeats);
		builder.append(", availableSeats=");
		builder.append(availableSeats);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
	
	
	