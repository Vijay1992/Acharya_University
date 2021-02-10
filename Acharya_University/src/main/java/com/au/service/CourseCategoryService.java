package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CourseCategory;
import com.au.repository.CourseCategoryRepository;


@Service
@Transactional
public class CourseCategoryService {

	@Autowired
	private CourseCategoryRepository CourseCategory_repository;
	
	public List<CourseCategory> listAll(){
		return CourseCategory_repository.findAll();
	}
	
	public CourseCategory save_CourseCategory(CourseCategory course) {
		return CourseCategory_repository.save(course);
	}
	
	public CourseCategory get(Integer id) {
        return CourseCategory_repository.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Course Category Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	CourseCategory cc = CourseCategory_repository.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Course Category Not Found:"+id));    	
    	CourseCategory_repository.delete(cc);
    }
}
