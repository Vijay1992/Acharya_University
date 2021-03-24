package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.FeeAdmissionCategory;

@Repository
public interface FeeAdmissionCategoryRepository extends JpaRepository<FeeAdmissionCategory, Integer> {

	
	@Query(value = "SELECT * FROM tbl_au_fee_admisison_category where active=1",nativeQuery =  true)
	public	List<FeeAdmissionCategory>  findAll();
}
