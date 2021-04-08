package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Roles;
import com.au.repository.RolesRepository;

@Service
@Transactional
public class RolesService {
	
	@Autowired
	private RolesRepository rr_repo;
	
	public List<Roles> listAll() {
		return rr_repo.findAll();
	}

	public Roles saveRoles(Roles roles) {
		return rr_repo.save(roles);
	}

	public Roles get(Integer id) {
		return rr_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Roles Id Not Found:" + id));
	}

	public void delete(Integer id) {
		Roles ay = rr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Roles Id Not Found:" + id));
		rr_repo.delete(ay);
	}

}
