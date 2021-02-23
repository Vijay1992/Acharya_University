package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CreditCategory;
import com.au.repository.CreditCategoryRepository;


@Service
@Transactional
public class CreditCategoryService {

	@Autowired
	private CreditCategoryRepository credit_repo;
	
	public List<CreditCategory> listAll(){
		return credit_repo.findAll();
	}
	
	public CreditCategory save_CreditCategory(CreditCategory credit) {
		return credit_repo.save(credit);
	}
	
	public CreditCategory get(Integer id) {
        return credit_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Credit Category id Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	CreditCategory cc = credit_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Credit Category id Not Found:"+id));    	
    	credit_repo.delete(cc);
    }
	
}
