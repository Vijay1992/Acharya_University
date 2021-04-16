package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.AttachmentsCategory;
import com.au.repository.AttachmentsCategoryRepository;

@Service
@Transactional
public class AttachmentsCategoryService {
	
	@Autowired
	private AttachmentsCategoryRepository acr_repo;

	public List<AttachmentsCategory> listAll() {
		return acr_repo.findAll();
	}

	public AttachmentsCategory saveAttachmentsCategory(AttachmentsCategory attachmentscategory) {
		return acr_repo.save(attachmentscategory);
	}

	public AttachmentsCategory get(Integer id) {
		if (id.equals(0)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return acr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AttachmentsCategory id Not Found:" + id));
	}

	public void delete(Integer id) {
		AttachmentsCategory ay = acr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AttachmentsCategory id Not Found:" + id));
		acr_repo.delete(ay);
	}


}
