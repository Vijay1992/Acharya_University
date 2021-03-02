package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.au.model.Course;

@Repository

@Transactional
public interface Course_Repository  extends JpaRepository<Course, Integer>{

}
