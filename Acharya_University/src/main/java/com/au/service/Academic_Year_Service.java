package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.model.Academic_year;
import com.au.repository.Academic_year_repository;

@Service
@Transactional
public class Academic_Year_Service {

	@Autowired
	private Academic_year_repository ac_repo;
	
	public List<Academic_year> listAll(){
		return ac_repo.findAll();
	}
	
	public Academic_year save_Academic_Year(Academic_year academic) {
		return ac_repo.save(academic);
	}
	
	public Academic_year get(Integer id) {
        return ac_repo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	ac_repo.deleteById(id);
    }
}
