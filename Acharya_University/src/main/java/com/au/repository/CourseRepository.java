package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.Course;
import com.au.model.Schools;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer>{

}
