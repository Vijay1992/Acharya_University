package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.YearSem;
import com.au.repository.YearSemRepository;

@Service
@Transactional
public class YearSemService {

	@Autowired
	private YearSemRepository year_repo;

	public List<YearSem> listAll() {
		return year_repo.findAll();
	}

	public YearSem save_YearSem(YearSem sem) {
		return year_repo.save(sem);
	}

	public YearSem get(Integer id) {
		return year_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Year Not Found:" + id));
	}

	public void delete(Integer id) {
		YearSem ys = year_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Year Not Found:" + id));
		year_repo.delete(ys);
	}

}
