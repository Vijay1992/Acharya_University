package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Program_Master;
import com.au.repository.Program_Master_Repository;

@Service
@Transactional
public class Program_Master_Service {

	@Autowired
	private Program_Master_Repository pr_repo;
	
	public List<Program_Master> listAll(){
		return pr_repo.findAll();
	}
	
	public Program_Master save_Program_Master(Program_Master academic) {
		return pr_repo.save(academic);
	}
	
	public Program_Master get(Integer id) {
        return pr_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Program Master Not Found:"+id));
    }
     
    public void delete(Integer id) {
     Program_Master pm =	pr_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Program Master Not Found:"+id));    	
    	pr_repo.delete(pm);
    }
}
