package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.AttachmentCategory;
import com.au.repository.AttachmentCategoryRepository;

@Service
@Transactional
public class AttachmentCategoryService {

	@Autowired
	private AttachmentCategoryRepository a_repo;


	public List<AttachmentCategory> listAll(){
		return a_repo.findAll();
	}
	
	public AttachmentCategory saveAttachmentCategory(AttachmentCategory a) {
		return a_repo.save(a);
	}
	
	public AttachmentCategory get(Integer id) {
        return a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AttachmentCategory Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	AttachmentCategory ay = a_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("AttachmentCategory Not Found:"+id));    	
    	a_repo.delete(ay);
    }
    
}
