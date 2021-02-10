package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CreditSystem;
import com.au.repository.CreditSystemRepository;


@Service
@Transactional
public class CreditSystemService {

	@Autowired
	private CreditSystemRepository credit_repo;

	
	public List<CreditSystem> listAll(){
		return credit_repo.findAll();
	}
	
	public CreditSystem save_CreditSystem(CreditSystem academic) {
		return credit_repo.save(academic);
	}
	
	public CreditSystem get(Integer id) {
        return credit_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Credit System Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	CreditSystem cs = credit_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Credit System Not Found:"+id));    	
    	credit_repo.delete(cs);
    }
}
