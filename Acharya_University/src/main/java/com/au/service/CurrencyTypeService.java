package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Currency_Type;
import com.au.repository.CurrencyTypeRepository;

@Service
@Transactional
public class CurrencyTypeService {

	@Autowired
	private CurrencyTypeRepository ct_repo;
	
	
	public List<Currency_Type> listAll(){
		return ct_repo.findAll();
	}
	
	public Currency_Type saveCurrency_Type(Currency_Type academic) {
		return ct_repo.save(academic);
	}
	
	public Currency_Type get(Integer id) {
        return ct_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Currency_Type Found:"+id));
    }
     
    public void delete(Integer id) {
    	Currency_Type ay = ct_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Currency_Type Found:"+id));    	
    	ct_repo.delete(ay);
    }
    
}
