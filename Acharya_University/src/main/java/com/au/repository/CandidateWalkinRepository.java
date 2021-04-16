package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.dto.Candidate_walkinRequest;
import com.au.model.Candidate_Walkin;
import com.au.model.PGApplicable;

@Repository
public interface CandidateWalkinRepository extends JpaRepository<Candidate_Walkin,Integer>{

	@Query(value = "SELECT candidate_id FROM tbl_au_candidate_walkin where candidate_id=?1",nativeQuery = true)
	public Candidate_Walkin findByCandidateId(Integer pg_id);
}
