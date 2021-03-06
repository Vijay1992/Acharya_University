package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.model.Program;
import com.au.repository.Program_Repository;

@Service
@Transactional
public class Program_Service {
	
	@Autowired
	private Program_Repository pro_repo;
	
	public List<Program> listAll(){
		return pro_repo.findAll();
	}
	
	public Program save_Program(Program academic) {
		return pro_repo.save(academic);
	}
	
	public Program get(Integer id) {
        return pro_repo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	pro_repo.deleteById(id);
    }
}