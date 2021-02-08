package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.model.Course;
import com.au.repository.Course_Repository;

@Service
@Transactional
public class Course_Service {

	@Autowired
	private Course_Repository course_repository;
	
	public List<Course> listAll(){
		return course_repository.findAll();
	}
	
	public Course saveCourse(Course course) {
		return course_repository.save(course);
	}
	
	public Course get(Integer id) {
        return course_repository.findById(id).get();
    }
     
    public void delete(Integer id) {
        course_repository.deleteById(id);
    }
	
}
