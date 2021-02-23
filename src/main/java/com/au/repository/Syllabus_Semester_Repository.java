package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.model.Syllabus_semester;

@Repository
public interface Syllabus_Semester_Repository extends JpaRepository<Syllabus_semester, Integer>{

}
