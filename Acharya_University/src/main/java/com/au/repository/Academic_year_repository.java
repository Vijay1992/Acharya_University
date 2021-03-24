package com.au.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Academic_year;
import com.au.model.ProgramType;


@Repository
public interface Academic_year_repository extends JpaRepository<Academic_year,Integer>
{
	public static final String FIND_PROJECTS = "SELECT * FROM tbl_au_academic_year where current_year>=year(now())-1 and active=1";

	
	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public  List<Academic_year> findByAcYearId();
	
	
	@Query(value = "select count(*) from tbl_au_academic_year where active=1 ",nativeQuery = true)
	public Integer countRecords();
	
	
	@Query(value = "SELECT * FROM tbl_au_academic_year where active=1",nativeQuery =  true)
	public	List<Academic_year>  findAll();

}
