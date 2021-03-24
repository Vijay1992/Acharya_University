package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.ProgramSpecilization;

@Repository
public interface ProgramSpecilizationRepository extends JpaRepository<ProgramSpecilization, Integer>{

	@Query(value="SELECT * FROM tbl_au_program_specialization where school_id=?1 and program_id=?2", nativeQuery= true)
	public List<ProgramSpecilization> findById1(Integer program_id,Integer school_id );


	@Query(value=" SELECT count(*) FROM tbl_au_program where school_id=?1",nativeQuery = true)
	public Integer findById2(Integer school_id);
	
}
