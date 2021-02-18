package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.AcademicYear;
import com.au.repository.AcademicYearRepository;

@Service
@Transactional
public class AcademicYearService {

	@Autowired
	private AcademicYearRepository ac_repo;

	public List<AcademicYear> listAll() {
		return ac_repo.findAll();
	}

	public AcademicYear save_Academic_Year(AcademicYear academic) {
		return ac_repo.save(academic);
	}

	public AcademicYear get(Integer id) {
		return ac_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Academic Year Not Found:" + id));
	}

	public void delete(Integer id) {
		AcademicYear ay = ac_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Academic Year Not Found:" + id));
		ac_repo.delete(ay);
	}
}