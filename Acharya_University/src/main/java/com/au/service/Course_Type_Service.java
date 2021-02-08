package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Course_Category;
import com.au.model.Course_Type;
import com.au.model.Department;
import com.au.repository.Course_Type_Repository;

@Service
@Transactional
public class Course_Type_Service {

	@Autowired
	private Course_Type_Repository course_type_repo;

	
	public List<Course_Type> listAll(){
		return course_type_repo.findAll();
	}
	
	public Course_Type save_Course_Type(Course_Type course) {
		return course_type_repo.save(course);
	}
	
	public Course_Type get(Integer id) {
        return course_type_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Course Type Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Course_Type ct =  course_type_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Course Type Not Found:"+id));    	
    	course_type_repo.delete(ct);
    }
}
