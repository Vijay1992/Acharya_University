package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.model.Schools;
import com.au.repository.School_Repository;

@Service
@Transactional
public class School_Service {

	@Autowired
	private School_Repository sc_repo;
	
	public List<Schools> listAll(){
		return sc_repo.findAll();
	}
	
	public Schools save_School(Schools course) {
		return sc_repo.save(course);
	}
	
	public Schools get(Integer id) {
        return sc_repo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	sc_repo.deleteById(id);
    }
}
