package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Course_Type;

@Repository
public interface Course_Type_Repository extends JpaRepository<Course_Type, Integer>{

}
