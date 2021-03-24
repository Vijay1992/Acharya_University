package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Schools;

@Repository
public interface School_Repository  extends JpaRepository<Schools, Integer>{

	@Query(value = "SELECT * FROM tbl_au_schools where active=true",nativeQuery =  true)
	public	List<Schools>  findAll();
	
}
