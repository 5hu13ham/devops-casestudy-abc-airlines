package com.myapp.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.model.Search;

public interface SearchRepository extends JpaRepository<Search, Integer>{
	
	
	List<Search> findBySourceCityAndDestinationCityAndDate(String sourceCity,String destinationCity,Date date);

}
