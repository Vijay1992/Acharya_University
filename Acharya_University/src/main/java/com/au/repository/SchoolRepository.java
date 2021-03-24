package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Schools;

@Repository
public interface SchoolRepository extends JpaRepository<Schools, Integer> {

	@Query(value = "SELECT * FROM tbl_au_schools where active=1", nativeQuery = true)
	public List<Schools> findAll();

}
