package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.exception.ResourceNotFoundException;
import com.au.model.AcademicProgram;
import com.au.model.AliasName;
import com.au.repository.AliasNameRepository;

@Service
public class AliasNameService {

	@Autowired
	private AliasNameRepository a_repo;
	
	public List<AliasName> listAll(){
		return a_repo.findAll();
	}
	
	public AliasName save_AliasName(AliasName academic) {
		return a_repo.save(academic);
	}
	
	public AliasName get(Integer id) {
        return a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AliasName Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	AliasName ay = a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AliasName Not Found:"+id));    	
    	a_repo.delete(ay);
    }
    
}
