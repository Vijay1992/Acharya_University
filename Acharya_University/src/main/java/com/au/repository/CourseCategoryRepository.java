package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.CourseCategory;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Integer> {

}
