package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.FeeAdmissionSubCategory;

@Repository
public interface FeeAdmissionSubCategoryRepository extends JpaRepository<FeeAdmissionSubCategory, Integer>{

	@Query(value = "SELECT fee_admission_sub_category_name FROM tbl_au_fee_admission_sub_category where fee_admission_category_id=?1",nativeQuery = true)
	public List<String> getFeeAdmissionByFeeAdmissionCategoryId(Integer fee_admission_category_id);
	
}
