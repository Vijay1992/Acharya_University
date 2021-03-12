package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeAdmissionSubCategory;
import com.au.repository.FeeAdmissionSubCategoryRepository;

@Service
@Transactional
public class FeeAdmissionSubCategoryService {
	
	@Autowired
	private FeeAdmissionSubCategoryRepository fasr_repo;

	public List<FeeAdmissionSubCategory> listAll() {
		return fasr_repo.findAll();
	}

	public FeeAdmissionSubCategory saveAdmissionSubCategory(FeeAdmissionSubCategory academic) {
		return fasr_repo.save(academic);
	}

	public FeeAdmissionSubCategory get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return fasr_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeeAdmissionSubCategory id Not Found:" + id));
	}

	public void delete(Integer id) {
		FeeAdmissionSubCategory ay = fasr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeeAdmissionSubCategory id Not Found:" + id));
		fasr_repo.delete(ay);
	}

	public List<String> findByfetchDetails(Integer fee_admission_category_id) {
		return fasr_repo.findById123(fee_admission_category_id);
	}

}
