package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Ledger;
import com.au.repository.LedgerRepository;

@Service
@Transactional
public class LedgerService {

	@Autowired
	private LedgerRepository lr;
	
	public List<Ledger> listAll(){
		return lr.findAll();
	}
	
	public Ledger save_Ledger(Ledger academic) {
		return lr.save(academic);
	}
	
	public Ledger get(Integer id) {
        return lr.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Academic Year Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Ledger ay = lr.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Academic Year Not Found:"+id));    	
    	lr.delete(ay);
    }
	
}
