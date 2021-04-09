package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.AttachmentSubCategory;
import com.au.repository.AttachmentSubCategoryRepository;

@Service
@Transactional
public class AttachmentSubCategoryService {

	@Autowired
	private AttachmentSubCategoryRepository a_repo;

	
	public List<AttachmentSubCategory> listAll(){
		return a_repo.findAll();
	}
	
	public AttachmentSubCategory saveAttachmentSubCategory(AttachmentSubCategory a) {
		return a_repo.save(a);
	}
	
	public AttachmentSubCategory get(Integer id) {
        return a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AttachmentSubCategory Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	AttachmentSubCategory ay = a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AttachmentSubCategory Not Found:"+id));    	
    	a_repo.delete(ay);
    }
    
}

