package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Academic_year;
import com.au.model.CourseAssignment;
import com.au.repository.CourseAssignmentRepository;

@Service
@Transactional
public class CourseAssignmentService {

	@Autowired
	private CourseAssignmentRepository carepo;

	
	public List<CourseAssignment> listAll(){
		return carepo.findAll();
	}
	
	public CourseAssignment save_CourseAssignment(CourseAssignment c) {
		return carepo.save(c);
	}
	
	public CourseAssignment get(Integer id) {
        return carepo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("CourseAssignment  Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	CourseAssignment ay = carepo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("CourseAssignment  Not Found:"+id));    	
    	carepo.delete(ay);
    }
}
