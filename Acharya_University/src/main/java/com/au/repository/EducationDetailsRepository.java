package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.EducationDetails;

@Repository
public interface EducationDetailsRepository extends JpaRepository<EducationDetails, Integer>{

}
