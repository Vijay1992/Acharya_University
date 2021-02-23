package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CourseBranch;
import com.au.repository.CourseBranchRepository;

@Service
@Transactional
public class CourseBranchService {

	@Autowired
	private CourseBranchRepository cb_repo;

	public List<CourseBranch> listAll() {
		return cb_repo.findAll();
	}

	public CourseBranch saveCourseBranch(CourseBranch coursebranch) {
		return cb_repo.save(coursebranch);
	}

	public CourseBranch get(Integer id) {
		if (id.equals(150)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return cb_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Branch id Not Found:" + id));
	}

	public void delete(Integer id) {
		CourseBranch ay = cb_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Branch id Not Found:" + id));
		cb_repo.delete(ay);
	}

}
