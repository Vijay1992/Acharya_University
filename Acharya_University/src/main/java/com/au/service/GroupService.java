package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Group;
import com.au.repository.GroupRepository;

@Service
@Transactional
public class GroupService {
	
	@Autowired
	private GroupRepository gr_repo;

	public List<Group> listAll() {
		return gr_repo.findAll();
	}

	public Group saveGroup(Group group) {
		return gr_repo.save(group);
	}

	public Group get(Integer id) {
		if (id.equals(180)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return gr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Group id Not Found:" + id));
	}

	public void delete(Integer id) {
		Group ay = gr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Group id Not Found:" + id));
		gr_repo.delete(ay);
	}


}
