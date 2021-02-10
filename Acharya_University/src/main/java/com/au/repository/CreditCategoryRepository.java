package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.CreditCategory;

@Repository
public interface CreditCategoryRepository extends JpaRepository<CreditCategory, Integer> {

}
