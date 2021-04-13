package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.ExperienceDetails;

@Repository
public interface ExperienceDetailsRepository extends JpaRepository<ExperienceDetails, Integer> {

}
