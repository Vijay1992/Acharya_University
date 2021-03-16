package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.AcademicYear;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Integer> {

	@Query(value = "SELECT * FROM tbl_au_academic_year where current_year>=year(now())-1", nativeQuery = true)
	public List<AcademicYear> findById12();

}
