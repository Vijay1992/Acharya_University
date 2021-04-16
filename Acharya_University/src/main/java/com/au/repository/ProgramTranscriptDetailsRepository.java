package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.ProgramTranscriptDetails;

@Repository
public interface ProgramTranscriptDetailsRepository  extends JpaRepository<ProgramTranscriptDetails, Integer>{

	@Query(value = "SELECT count(*) FROM au_db1.tbl_au_transcrption_details where transcript_details=?1 and  program_id=?2",nativeQuery = true)
	public Integer getProgramTranscriptDetails(String name,Integer program_id);
	
}
