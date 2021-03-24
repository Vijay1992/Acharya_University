package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.AcademicProgram;

@Repository
public interface AcademicProgramRepository extends JpaRepository<AcademicProgram, Integer>{

	@Query(value = "select number_of_years,number_of_semester from tbl_au_academic_program where program_id=?1 and ac_year_id=?2",nativeQuery = true)
	public List<Integer[]> getNumOfSemAndYearByProgram_IdAndAcYear_Id(Integer program_id,Integer ac_year_id);
	
}
