package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Year_Sem;
import com.au.repository.Year_Sem_Repository;

@Service
@Transactional
public class Year_Sem_Service {

	@Autowired
	private Year_Sem_Repository year_repo;
	
	public List<Year_Sem> listAll(){
		return year_repo.findAll();
	}
	
	public Year_Sem save_Year_Sem(Year_Sem sem) {
		return year_repo.save(sem);
	}
	
	public Year_Sem get(Integer id) {
        return year_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Year Not Found:"+id));
    }
     
    public void delete(Integer id) {
    Year_Sem ys = year_repo.findById(id)
    		.orElseThrow(()-> new ResourceNotFoundException("Year Not Found:"+id));
    	year_repo.delete(ys);
     }
	
}
