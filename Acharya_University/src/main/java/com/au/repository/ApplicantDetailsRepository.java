package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.ApplicantDetails;
import com.au.model.PGApplicable;

@Repository
public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails, Integer>{

	@Query(value = "SELECT * FROM tbl_au_applicant_details where applicant_id=?1",nativeQuery = true)
	public ApplicantDetails findByAppId(Integer applicant_id);
	
	
}
