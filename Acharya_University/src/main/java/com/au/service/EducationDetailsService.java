package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.EducationDetails;
import com.au.repository.EducationDetailsRepository;

@Service
@Transactional
public class EducationDetailsService {

	@Autowired
	private EducationDetailsRepository edr_repo;

	public List<EducationDetails> listAll() {
		return edr_repo.findAll();
	}

	public List<EducationDetails> saveEducationDetails(List<EducationDetails> educationdetails) {
		return edr_repo.saveAll(educationdetails);
	}

	public EducationDetails get(Integer id) {
		if (id.equals(0)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return edr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EducationDetails id Not Found:" + id));
	}

	public void delete(Integer id) {
		EducationDetails ay = edr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EducationDetails id Not Found:" + id));
		edr_repo.delete(ay);
	}

}
