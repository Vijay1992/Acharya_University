package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.CourseAssignment;

@Repository
public interface CourseAssignmentRepository extends JpaRepository<CourseAssignment	, Integer>{

}
