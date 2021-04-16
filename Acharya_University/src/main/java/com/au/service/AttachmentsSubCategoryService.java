package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.AttachmentsSubCategory;
import com.au.repository.AttachmentsSubCategoryRepository;

@Service
@Transactional
public class AttachmentsSubCategoryService {

	@Autowired
	private AttachmentsSubCategoryRepository ascr_repo;

	public List<AttachmentsSubCategory> listAll() {
		return ascr_repo.findAll();
	}

	public AttachmentsSubCategory saveAttachmentsSubCategory(AttachmentsSubCategory academic) {
		return ascr_repo.save(academic);
	}

	public AttachmentsSubCategory get(Integer id) {
		if (id.equals(0)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return ascr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AttachmentsSubCategory id Not Found:" + id));
	}

	public void delete(Integer id) {
		AttachmentsSubCategory ay = ascr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AttachmentsSubCategory id Not Found:" + id));
		ascr_repo.delete(ay);
	}

}
