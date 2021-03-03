package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Program;
import com.au.repository.ProgramRepository;

@Service
@Transactional
public class ProgramService {

	@Autowired
	private ProgramRepository pro_repo;

	public List<Program> listAll() {
		return pro_repo.findAll();
	}

	public Program save_Program(Program academic) {
		return pro_repo.save(academic);
	}

	public Program get(Integer id) {
		return pro_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Program id Not Found:" + id));
	}

	public void delete(Integer id) {
		Program p = pro_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Program id Not Found:" + id));
		pro_repo.delete(p);
	}

	public List<Program> findById(Integer id) {
		return pro_repo.findById123(id);
	}

	public Integer countRecords(Integer id) {
		return pro_repo.findById12(id);
	}

}