package com.au.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Academic_year;
import com.au.repository.Academic_year_repository;

@Service
@Transactional
public class AcademicYearService {

	@Autowired
	private Academic_year_repository ac_repo;
	
	public List<Academic_year> listAll(){
		return ac_repo.findAll();
	}
	
	public Academic_year save_Academic_Year(Academic_year academic) {
		return ac_repo.save(academic);
	}
	
	public Academic_year get(Integer id) {
        return ac_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Academic Year Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	Academic_year ay = ac_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("Academic Year Not Found:"+id));    	
    	ac_repo.delete(ay);
    }
    
    
    public List<Object[]> getAcademicYearByACYearId(Integer ac_year_id) {
    	return ac_repo.findByAcYearId(ac_year_id);
    }

	public Integer countRecords() {
		// TODO Auto-generated method stub
		return ac_repo.countRecords();
	}
}
