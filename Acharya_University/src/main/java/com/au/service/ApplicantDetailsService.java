package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.ApplicantDetails;
import com.au.repository.ApplicantDetailsRepository;

@Service
@Transactional
public class ApplicantDetailsService {

	@Autowired
	private ApplicantDetailsRepository a_repo;
	
	public List<ApplicantDetails> listAll(){
		return a_repo.findAll();
	}
	
	public ApplicantDetails saveApplicantDetails(ApplicantDetails a) {
		return a_repo.save(a);
	}
	
	public ApplicantDetails get(Integer id) {
        return a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ApplicantDetails Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	ApplicantDetails ay = a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("ApplicantDetails Not Found:"+id));    	
    	a_repo.delete(ay);
    }
    
}
