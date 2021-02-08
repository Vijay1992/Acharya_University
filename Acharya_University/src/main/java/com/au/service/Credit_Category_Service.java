package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Credit_Category;
import com.au.repository.Credit_Category_Repository;

@Service
@Transactional
public class Credit_Category_Service {

	@Autowired
	private Credit_Category_Repository credit_repo;
	
	public List<Credit_Category> listAll(){
		return credit_repo.findAll();
	}
	
	public Credit_Category save_Credit_Category(Credit_Category credit) {
		return credit_repo.save(credit);
	}
	
	public Credit_Category get(Integer id) {
        return credit_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Credit Category Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Credit_Category cc = credit_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Credit Category Not Found:"+id));    	
    	credit_repo.delete(cc);
    }
	
}
