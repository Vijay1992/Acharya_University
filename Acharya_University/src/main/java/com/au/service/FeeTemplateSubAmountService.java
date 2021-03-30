package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeTemplateSubAmount;
import com.au.repository.FeeTemplateSubAmountRepository;

@Service
@Transactional
public class FeeTemplateSubAmountService {

	@Autowired
	private FeeTemplateSubAmountRepository ftsa_repo;

	public List<FeeTemplateSubAmount> listAll() {
		return ftsa_repo.findAll();
	}

	public FeeTemplateSubAmount saveFeeTemplateSubAmount(FeeTemplateSubAmount feetemplatesubamount) {
		return ftsa_repo.save(feetemplatesubamount);
	}

	public FeeTemplateSubAmount get(Integer id) {
		if (id.equals(100000000)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return ftsa_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeeTemplateSubAmount id Not Found:" + id));
	}

	public void delete(Integer id) {
		FeeTemplateSubAmount ay = ftsa_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeeTemplateSubAmount id Not Found:" + id));
		ftsa_repo.delete(ay);
	}

}
