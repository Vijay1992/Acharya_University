package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Schools;
import com.au.repository.SchoolRepository;


@Service
@Transactional
public class SchoolService {

	@Autowired
	private SchoolRepository sc_repo;
	
	public List<Schools> listAll(){
		return sc_repo.findAll();
	}
	
	public Schools save_School(Schools school) {
		return sc_repo.save(school);
	}
	
	public Schools get(Integer id) {
        return sc_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("School id Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Schools s = sc_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("School id Not Found:"+id));    	
    	sc_repo.delete(s);
    }

	/*
	 * public Schools findById(Integer id) { // TODO Auto-generated method stub
	 * return sc_repo.findById123(id); }
	 */
   
    
}
