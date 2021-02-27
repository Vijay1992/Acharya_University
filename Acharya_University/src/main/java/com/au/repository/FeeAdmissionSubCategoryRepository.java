package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.FeeAdmissionSubCategory;

@Repository
public interface FeeAdmissionSubCategoryRepository extends JpaRepository<FeeAdmissionSubCategory, Integer>{

}
