package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Tally;
import com.au.repository.TallyRepository;

@Service
@Transactional
public class TallyService {

	@Autowired
	private TallyRepository ty_repo;

	public List<Tally> listAll() {
		return ty_repo.findAll();
	}

	public Tally saveTally(Tally tally) {
		return ty_repo.save(tally);
	}

	public Tally get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return ty_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tally id Not Found:" + id));
	}

	public void delete(Integer id) {
		Tally ay = ty_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tally id Not Found:" + id));
		ty_repo.delete(ay);
	}

}
