package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.MajorStruc;
import com.au.repository.MajorStrucRepository;


@Service
@Transactional
public class MajorStrucService {

	@Autowired
	private MajorStrucRepository major_repo;
	
	public List<MajorStruc> listAll(){
		return major_repo.findAll();
	}
	
	public MajorStruc save_MajorStruc(MajorStruc major) {
		return major_repo.save(major);
	}
	
	public MajorStruc get(Integer id) {
		return major_repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Major struc Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	MajorStruc ms = major_repo.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Major struc Not Found:"+id));    	
    	major_repo.delete(ms);
    }
}
