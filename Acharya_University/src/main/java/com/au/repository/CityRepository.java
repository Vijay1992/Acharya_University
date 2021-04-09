package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

	
	@Query(value = "SELECT * FROM tbl_au_cities where  state_id=?1 and  country_id=?2",nativeQuery = true)
	public List<City> getCityByStateAndCountry(Integer state_id,Integer country_id);
	
}
