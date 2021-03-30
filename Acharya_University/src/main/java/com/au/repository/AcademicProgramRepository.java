package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.AcademicProgram;

@Repository
public interface AcademicProgramRepository extends JpaRepository<AcademicProgram, Integer>{

	@Query(value = "select * from tbl_au_academic_program where ac_year_id=?1 and program_id=?2 and active=1",nativeQuery = true)
	public List<AcademicProgram> getNumOfSemAndYearByProgram_IdAndAcYear_Id(Integer ac_year_id,Integer program_id);
	
	
	@Query(value = "SELECT count(*) FROM au_db1.tbl_au_academic_program where ac_year_id=?1 and program_id=?2",nativeQuery = true)
	public Integer getProgram(Integer ac_year_id,Integer  program_id);
	
}
