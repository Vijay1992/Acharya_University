package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.ProgramSpecialization;

@Repository
public interface ProgramSpecializationRepository extends JpaRepository<ProgramSpecialization, Integer> {
	
	//@Query("SELECT u FROM Program u where u.school_id=?1")
	//public List<Program> findById1(Integer );
	
	@Query(value="SELECT * FROM tbl_au_program_specialization where program_id=?1 and school_id=?2", nativeQuery= true)
	public List<ProgramSpecialization> findById1(Integer program_id,Integer school_id );
	
	
	@Query(value=" SELECT count(*) FROM tbl_au_program where school_id=?1",nativeQuery = true)
	public Integer findById12(Integer school_id);

}
