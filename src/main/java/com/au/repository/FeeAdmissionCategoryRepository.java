package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.FeeAdmissionCategory;

@Repository
public interface FeeAdmissionCategoryRepository extends JpaRepository<FeeAdmissionCategory, Integer> {

}
