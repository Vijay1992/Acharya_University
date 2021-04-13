package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.JobProfile;
import com.au.repository.JobProfileRepository;

@Service
@Transactional
public class JobProfileService {

	@Autowired
	private JobProfileRepository jpr_repo;

	public List<JobProfile> listAll() {
		return jpr_repo.findAll();
	}

	public JobProfile saveJobProfile(JobProfile jobprofile) {
		return jpr_repo.save(jobprofile);
	}

	public JobProfile get(Integer id) {
		if (id.equals(0)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return jpr_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("JobProfile id Not Found:" + id));
	}

	public void delete(Integer id) {
		JobProfile ay = jpr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("JobProfile id Not Found:" + id));
		jpr_repo.delete(ay);
	}

}
