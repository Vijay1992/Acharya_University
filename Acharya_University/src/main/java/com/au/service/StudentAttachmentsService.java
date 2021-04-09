package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Academic_year;
import com.au.model.StudentAttachments;
import com.au.repository.StudentAttachmentsRepository;

@Service
@Transactional
public class StudentAttachmentsService {

	@Autowired
	private StudentAttachmentsRepository s_repo;
	
	public List<StudentAttachments> listAll(){
		return s_repo.findAll();
	}
	
	public StudentAttachments saveStudentAttachments(StudentAttachments academic) {
		return s_repo.save(academic);
	}
	
	public StudentAttachments get(Integer id) {
        return s_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("StudentAttachments Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	StudentAttachments ay = s_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("StudentAttachments Not Found:"+id));    	
    	s_repo.delete(ay);
    }
	
}
