package com.au.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Organization;
import com.au.repository.OrganizationRepository;

@Service
@Transactional
public class OrganisationService {
	
	@Autowired
	private OrganizationRepository org_repo;

	public List<Organization> listAll() {
		return org_repo.findAll();
	}

	public Organization saveOrganisation(Organization organization) {
		return org_repo.save(organization);
	}

	public Organization get(Integer id) {
		return org_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organization id Not Found:" + id));
	}

	public void delete(Integer id) {
		Organization ay = org_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organization id Not Found:" + id));
		org_repo.delete(ay);
	}

}
