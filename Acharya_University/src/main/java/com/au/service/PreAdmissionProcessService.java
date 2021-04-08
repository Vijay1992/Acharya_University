package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.PreAdmissionProcess;
import com.au.repository.PreAdmissionProcessRepository;

@Service
@Transactional
public class PreAdmissionProcessService {
	
	@Autowired
	private PreAdmissionProcessRepository p_repo;
	
	public List<PreAdmissionProcess> listAll(){
		return p_repo.findAll();
	}
	
	public PreAdmissionProcess save_PreAdmissionProcess(PreAdmissionProcess academic) {
		return p_repo.save(academic);
	}
	
	public PreAdmissionProcess get(Integer id) {
        return p_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("PreAdmissionProcess Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	PreAdmissionProcess ay = p_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("PreAdmissionProcess Not Found:"+id));    	
    	p_repo.delete(ay);
    }
	
}
