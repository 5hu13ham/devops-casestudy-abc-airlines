package com.myapp.spring.model;

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
	private Integer flighttId;
	
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

	public aircraft() {
		
		// TODO Auto-generated constructor stub
	}

	public aircraft(String flightName, String sourceCity, String destinationCity, Double price, Double duration, String aircraftType, String schedules) {
		this.flightName = flightName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.price = price;
		this.duration = duration;
		this.aircraftType = aircraftType;
		this.schedules = schedules;
	}

	public Integer getFlighttId() {
		return flighttId;
	}

	public void setFlighttId(Integer flighttId) {
		this.flighttId = flighttId;
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

	@Override
	public int hashCode() {
		return Objects.hash(destinationCity, duration, flightName, flighttId, price, sourceCity, aircraftType, schedules);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof aircraft))
			return false;
		aircraft other = (aircraft) obj;
		return Objects.equals(destinationCity, other.destinationCity) && Objects.equals(duration, other.duration)
				&& Objects.equals(flightName, other.flightName) && Objects.equals(flighttId, other.flighttId)
				&& Objects.equals(price, other.price) && Objects.equals(sourceCity, other.sourceCity) && Objects.equals(aircraftType, other.aircraftType) && Objects.equals(schedules, other.schedules);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [flighttId=");
		builder.append(flighttId);
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
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	
	

}
