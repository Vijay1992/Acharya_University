package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Course_Category;

@Repository
public interface Course_Category_Repository extends JpaRepository<Course_Category, Integer>{

}
