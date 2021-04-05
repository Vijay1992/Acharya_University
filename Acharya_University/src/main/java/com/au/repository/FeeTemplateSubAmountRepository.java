package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.FeeTemplateSubAmount;

@Repository
public interface FeeTemplateSubAmountRepository extends JpaRepository<FeeTemplateSubAmount, Integer> {

	
	
	
}
