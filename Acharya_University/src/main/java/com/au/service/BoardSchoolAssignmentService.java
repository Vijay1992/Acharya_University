package com.au.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.BoardSchoolAssignment;
import com.au.repository.BoardSchoolAssignmentRepository;

@Service
@Transactional
public class BoardSchoolAssignmentService {

	@Autowired
	private BoardSchoolAssignmentRepository bs_repo;

	public List<BoardSchoolAssignment> listAll() {
		return bs_repo.findAll();
	}

	public BoardSchoolAssignment save_BoardSchoolAssignment(BoardSchoolAssignment academic) {
		return bs_repo.save(academic);
	}

	public BoardSchoolAssignment get(Integer id) {
		return bs_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BoardSchoolAssignment Not Found:" + id));
	}

	public void delete(Integer id) {
		BoardSchoolAssignment ay = bs_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BoardSchoolAssignment Not Found:" + id));
		bs_repo.delete(ay);
	}

	public List<String> findByfetchDetails(Integer school_id) {
		return bs_repo.findById12(school_id);
				
	}

	public Integer countRecords(Integer id) {
		return bs_repo.findById123(id);
	}

}
