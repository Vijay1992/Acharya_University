package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeAdmissionCategory;
import com.au.repository.FeeAdmissionCategoryRepository;

@Service
@Transactional
public class FeeAdmissionCategoryService {

	@Autowired
	private FeeAdmissionCategoryRepository fac_repo;

	public List<FeeAdmissionCategory> listAll() {
		return fac_repo.findAll();
	}

	public FeeAdmissionCategory saveFeeAdmissionCategory(FeeAdmissionCategory feeadmissioncategory) {
		return fac_repo.save(feeadmissioncategory);
	}

	public FeeAdmissionCategory get(Integer id) {
		if (id.equals(20)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return fac_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fee Admission Category id Not Found:" + id));
	}

	public void delete(Integer id) {
		FeeAdmissionCategory ay = fac_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fee Admission Category id Not Found:" + id));
		fac_repo.delete(ay);
	}

}
