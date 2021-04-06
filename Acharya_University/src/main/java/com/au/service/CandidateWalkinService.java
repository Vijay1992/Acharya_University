package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Candidate_Walkin;
import com.au.repository.CandidateWalkinRepository;

@Service
@Transactional
public class CandidateWalkinService {

	@Autowired
	private CandidateWalkinRepository can_repo;
	
	
	public List<Candidate_Walkin> listAll(){
		return can_repo.findAll();
	}
	
	public Candidate_Walkin save_Candidate_Walkin(Candidate_Walkin academic) {
		return can_repo.save(academic);
	}
	
	public Candidate_Walkin get(Integer id) {
        return can_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Candidate_Walkin Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Candidate_Walkin ay = can_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Candidate_Walkin Not Found:"+id));    	
    	can_repo.delete(ay);
    }
    
}
