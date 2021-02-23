package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Major_struc;
import com.au.repository.Major_struc_Repository;


@Service
@Transactional
public class Major_struc_Service {

	@Autowired
	private Major_struc_Repository major_repo;
	
	public List<Major_struc> listAll(){
		return major_repo.findAll();
	}
	
	public Major_struc save_Major_struc(Major_struc major) {
		return major_repo.save(major);
	}
	
	public Major_struc get(Integer id) {
		return major_repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Major struc Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Major_struc ms = major_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Major struc Not Found:"+id));    	
    	major_repo.delete(ms);
    }
}
