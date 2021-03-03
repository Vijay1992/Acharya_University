package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.ProgramSpecialization;
import com.au.repository.ProgramSpecializationRepository;

@Service
@Transactional
public class ProgramSpecializationService {

	@Autowired
	private ProgramSpecializationRepository psr_repo;

	public List<ProgramSpecialization> listAll() {
		return psr_repo.findAll();
	}

	public ProgramSpecialization saveProgramSpecialization(ProgramSpecialization programspecialization) {
		return psr_repo.save(programspecialization);
	}

	public ProgramSpecialization get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return psr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Program Specialization id Not Found:" + id));
	}

	public void delete(Integer id) {
		ProgramSpecialization ay = psr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Program Specialization id Not Found:" + id));
		psr_repo.delete(ay);
	}

	public List<ProgramSpecialization> findById(Integer id1, Integer id2) {
		return psr_repo.findById1(id1, id2);
	}

	public Integer countRecords(Integer id) {
		return psr_repo.findById12(id);
	}

}
