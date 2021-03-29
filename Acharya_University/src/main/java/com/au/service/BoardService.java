package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.applicationdiscovery.model.ResourceNotFoundException;
import com.au.model.Board;
import com.au.repository.BoardRepository;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardRepository bo_repo;

	public List<Board> listAll() {
		return bo_repo.findAll();
	}

	public Board saveBoard(Board academic) {
		return bo_repo.save(academic);
	}

	public Board get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return bo_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board id Not Found:" + id));
	}

	public void delete(Integer id) {
		Board ay = bo_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board id Not Found:" + id));
		bo_repo.delete(ay);
	}
}