package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Credit_System;
import com.au.repository.Credit_System_Repository;

@Service
@Transactional
public class Credit_System_Service {

	@Autowired
	private Credit_System_Repository credit_repo;

	
	public List<Credit_System> listAll(){
		return credit_repo.findAll();
	}
	
	public Credit_System save_Credit_System(Credit_System academic) {
		return credit_repo.save(academic);
	}
	
	public Credit_System get(Integer id) {
        return credit_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Credit System Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Credit_System cs = credit_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Credit System Not Found:"+id));    	
    	credit_repo.delete(cs);
    }
}
