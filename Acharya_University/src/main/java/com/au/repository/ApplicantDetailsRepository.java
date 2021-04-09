package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.ApplicantDetails;

@Repository
public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails, Integer>{

}
