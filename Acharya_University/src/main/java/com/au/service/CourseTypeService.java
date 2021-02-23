package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CourseType;
import com.au.repository.CourseTypeRepository;


@Service
@Transactional
public class CourseTypeService {

	@Autowired
	private CourseTypeRepository CourseType_repo;

	
	public List<CourseType> listAll(){
		return CourseType_repo.findAll();
	}
	
	public CourseType save_CourseType(CourseType course) {
		return CourseType_repo.save(course);
	}
	
	public CourseType get(Integer id) {
        return CourseType_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Course Type id Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	CourseType ct =  CourseType_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Course Type id Not Found:"+id));    	
    	CourseType_repo.delete(ct);
    }
}
