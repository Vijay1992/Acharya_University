package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.Credit_Category;

@Repository
public interface Credit_Category_Repository  extends JpaRepository<Credit_Category, Integer>{

}
