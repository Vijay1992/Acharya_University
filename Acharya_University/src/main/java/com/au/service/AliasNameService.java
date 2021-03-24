package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.AliasName;
import com.au.repository.AliasNameRepository;

@Service
@Transactional
public class AliasNameService {

	@Autowired
	private AliasNameRepository anr_repo;

	public List<AliasName> listAll() {
		return anr_repo.findAll();
	}

	public AliasName saveAliasName(AliasName aliasname) {
		return anr_repo.save(aliasname);
	}

	public AliasName get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return anr_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("AliasName id Not Found:" + id));
	}

	public void delete(Integer id) {
		AliasName ay = anr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AliasName id Not Found:" + id));
		anr_repo.delete(ay);
	}

}
