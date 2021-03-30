package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeTemplateSubAmount;
import com.au.repository.FeeTemplateSubAmountRepository;

@Service
@Transactional
public class FeeTemplateSubAmountService {

	@Autowired
	private FeeTemplateSubAmountRepository fee_repo;
	
	
	public List<FeeTemplateSubAmount> listAll(){
		return fee_repo.findAll();
	}
	
	public FeeTemplateSubAmount save_FeeTemplateSubAmount(FeeTemplateSubAmount f) {
		return fee_repo.save(f);
	}
	
	public FeeTemplateSubAmount get(Integer id) {
        return fee_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("FeeTemplateSubAmount Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	FeeTemplateSubAmount ay = fee_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("FeeTemplateSubAmount Not Found:"+id));    	
    	fee_repo.delete(ay);
    }
    
   
}
