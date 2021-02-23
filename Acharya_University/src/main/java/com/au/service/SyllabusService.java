package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Syllabus;
import com.au.repository.SyllabusRepository;


@Service
@Transactional
public class SyllabusService {

	@Autowired
	private SyllabusRepository syllabus_repository;
	
	public List<Syllabus> listAll(){
		return syllabus_repository.findAll();
	}
	
	public Syllabus save_Syllabus(Syllabus syllabus) {
		return syllabus_repository.save(syllabus);
	}
	
	public Syllabus get(Integer id) {
        return syllabus_repository.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Syllabus id Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Syllabus s =syllabus_repository.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Syllabus id Not Found:"+id));    	
    	syllabus_repository.delete(s);
    }
}
