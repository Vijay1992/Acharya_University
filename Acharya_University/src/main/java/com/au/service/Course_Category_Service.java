package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.model.Course;
import com.au.model.Course_Category;
import com.au.repository.Course_Category_Repository;

@Service
@Transactional
public class Course_Category_Service {

	@Autowired
	private Course_Category_Repository course_category_repository;
	
	public List<Course_Category> listAll(){
		return course_category_repository.findAll();
	}
	
	public Course_Category save_Course_Category(Course_Category course) {
		return course_category_repository.save(course);
	}
	
	public Course_Category get(Integer id) {
        return course_category_repository.findById(id).get();
    }
     
    public void delete(Integer id) {
    	course_category_repository.deleteById(id);
    }
}
