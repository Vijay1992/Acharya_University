package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.academic_school;
import com.au.repository.AcademicSchoolRepository;

@Service
@Transactional
public class AcademicSchoolService {

	@Autowired
	private AcademicSchoolRepository as_repo;

	public List<academic_school> listAll(){
		return as_repo.findAll();
	}
	
	public academic_school save_academic_school(academic_school a) {
	
			return as_repo.save(a);
	}
	
	public academic_school get(Integer id) {
        return as_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("academic_school Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	academic_school ay = as_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("academic_school Not Found:"+id));    	
    	as_repo.delete(ay);
    }
    
}
