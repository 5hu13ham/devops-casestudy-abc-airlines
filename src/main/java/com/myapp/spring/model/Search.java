package com.myapp.spring.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table(name = "abcflights1")
public class Search {
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
	
	@Column(name = "departure_date",nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	

	public Search() {
		
		// TODO Auto-generated constructor stub
	}

	public Search(String flightName, String sourceCity, String destinationCity, Double price, Double duration,Date date) {
		this.flightName = flightName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.price = price;
		this.duration = duration;
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
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flightId,flightName,sourceCity,destinationCity,price,duration,date);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Search))
			return false;
		Search other = (Search) obj;
		return Objects.equals(flightId, other.flightId) && Objects.equals(flightName, other.flightName)  && Objects.equals(sourceCity, other.sourceCity)  
				&& Objects.equals(destinationCity, other.destinationCity) && Objects.equals(duration, other.duration)
				&& Objects.equals(price, other.price) && Objects.equals(date, other.date);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [flightId=");
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
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	
	

}
