package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Graduation;
import com.au.repository.GraduationRepository;

@Service
@Transactional
public class GraduationService {

	@Autowired
	private GraduationRepository gr_repo;

	public List<Graduation> listAll() {
		return gr_repo.findAll();
	}

	public Graduation saveGraduation(Graduation graduation) {
		return gr_repo.save(graduation);
	}

	public Graduation get(Integer id) {
		if (id.equals(6)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return gr_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Graduation id Not Found:" + id));
	}

	public void delete(Integer id) {
		Graduation ay = gr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Graduation id Not Found:" + id));
		gr_repo.delete(ay);
	}

}
