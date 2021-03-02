package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.ProgramType;
import com.au.repository.ProgramTypeRepository;

@Service
@Transactional
public class ProgramTypeService {
	
	@Autowired
	private ProgramTypeRepository pr_repo;
	
	public List<ProgramType> listAll(){
		return pr_repo.findAll();
	}
	
	public ProgramType save_ProgramType(ProgramType academic) {
		return pr_repo.save(academic);
	}
	
	public ProgramType get(Integer id) {
        return pr_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramType Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	ProgramType ay = pr_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ProgramType Not Found:"+id));    	
    	pr_repo.delete(ay);
    }
}
