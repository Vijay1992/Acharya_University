package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Organization;
import com.au.repository.Org_Repository;

@Service
@Transactional
public class Org_service {

	@Autowired
	private Org_Repository org_repo;
	
	public List<Organization> listAll(){
		return org_repo.findAll();
	}
	
	public Organization save_Org(Organization org) {
		return org_repo.save(org);
	}
	
	public Organization get(Integer id) {
        return org_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Organization Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Organization ay = org_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Organization Not Found:"+id));    	
    	org_repo.delete(ay);
    }
	
}
