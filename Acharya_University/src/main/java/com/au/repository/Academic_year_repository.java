package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Academic_year;

@Repository
public interface Academic_year_repository extends JpaRepository<Academic_year,Integer>
{

	public static final String FIND_PROJECTS = "select ac_year_id,ac_year from tbl_au_academic_year where ac_year_id=?1";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public  List<Object[]> findByAcYearId(Integer ac_year_id);
	
	@Query(value = "select count(*) from tbl_au_academic_year",nativeQuery = true)
	public Integer countRecords();
	
}
