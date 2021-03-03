package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.ProgramType;
import com.au.repository.ProgramTypeRepository;

@Service
@Transactional
public class ProgramTypeService {

	@Autowired
	private ProgramTypeRepository ProgramType_repo;

	public List<ProgramType> listAll() {
		return ProgramType_repo.findAll();
	}

	public ProgramType saveProgramType(ProgramType program) {
		return ProgramType_repo.save(program);
	}

	public ProgramType get(Integer id) {
		return ProgramType_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Program Type id Not Found:" + id));
	}

	public void delete(Integer id) {
		ProgramType ct = ProgramType_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Program Type id Not Found:" + id));
		ProgramType_repo.delete(ct);
	}
}
