package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeAdmissionCategory;
import com.au.repository.FeeAdmissionCategoryRepository;

@Service
@Transactional
public class FeeAdmissionCategoryService {

	@Autowired
	private FeeAdmissionCategoryRepository fee_repo;
	
	
	public List<FeeAdmissionCategory> listAll(){
		return fee_repo.findAll();
	}
	
	public FeeAdmissionCategory saveFeeAdmissionCategory(FeeAdmissionCategory academic) {
		return fee_repo.save(academic);
	}
	
	public FeeAdmissionCategory get(Integer id) {
        return fee_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("FeeAdmissionCategory  Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	FeeAdmissionCategory ay = fee_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("FeeAdmissionCategory Not Found:"+id));    	
    	fee_repo.delete(ay);
    }
}
