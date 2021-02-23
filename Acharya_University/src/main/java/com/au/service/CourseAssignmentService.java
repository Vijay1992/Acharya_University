package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CourseAssignment;
import com.au.repository.CourseAssignmentRepository;

@Service
@Transactional
public class CourseAssignmentService {

	@Autowired
	private CourseAssignmentRepository ca_repo;

	public List<CourseAssignment> listAll() {
		return ca_repo.findAll();
	}

	public CourseAssignment saveCourseAssignment(CourseAssignment courseassignment) {
		return ca_repo.save(courseassignment);
	}

	public CourseAssignment get(Integer id) {
		if (id.equals(180)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return ca_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Assignment id Not Found:" + id));
	}

	public void delete(Integer id) {
		CourseAssignment ay = ca_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Assignment id Not Found:" + id));
		ca_repo.delete(ay);
	}

}
