package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
