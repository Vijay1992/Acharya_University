package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.TallyHead;
import com.au.repository.TallyHeadRepository;

@Service
@Transactional
public class TallyHeadService {

	@Autowired
	private TallyHeadRepository tally_repo;
	
	
	public List<TallyHead> listAll(){
		return tally_repo.findAll();
	}
	
	public TallyHead save_TallyHead(TallyHead academic) {
		return tally_repo.save(academic);
	}
	
	public TallyHead get(Integer id) {
        return tally_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("TallyHead Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	TallyHead ay = tally_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("TallyHead Not Found:"+id));    	
    	tally_repo.delete(ay);
    }
}
