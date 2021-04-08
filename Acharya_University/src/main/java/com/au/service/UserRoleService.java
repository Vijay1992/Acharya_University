package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.UserRole;
import com.au.repository.UserRoleRepository;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	private UserRoleRepository urr_repo;

	public List<UserRole> listAll() {
		return urr_repo.findAll();
	}

	public UserRole saveUserRole(UserRole userrole) {
		return urr_repo.save(userrole);
	}

	public UserRole get(Integer id) {
		return urr_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserRole Id Not Found:" + id));
	}

	public void delete(Integer id) {
		UserRole ay = urr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UserRole Id Not Found:" + id));
		urr_repo.delete(ay);
	}

}
