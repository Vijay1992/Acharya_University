package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
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
        return course_repository.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Course Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Course existingCourse = course_repository.findById(id)
    	        .orElseThrow(()-> new ResourceNotFoundException("Course Not Found:"+id));
    	this.course_repository.delete(existingCourse);
    }
	
}
