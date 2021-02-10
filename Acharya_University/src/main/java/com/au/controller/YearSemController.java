package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.au.model.YearSem;
import com.au.service.YearSemService;

@RestController
@RequestMapping("/api")
public class YearSemController {

	@Autowired
	private YearSemService sem_service;

	@PostMapping("/YearSem1")
	public YearSem saveCourse(@RequestBody @Valid YearSem year) {
		return sem_service.save_YearSem(year);
	}

	@GetMapping("/YearSem2")
	public List<YearSem> listAll() {
		return sem_service.listAll();
	}

	@GetMapping("/YearSem3/{id}")
	public ResponseEntity<YearSem> get(@PathVariable Integer id) {
		try {

			YearSem syllabus = sem_service.get(id);
			return new ResponseEntity<YearSem>(syllabus, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<YearSem>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/YearSem4/{id}")
	public ResponseEntity<YearSem> update(@RequestBody @Valid YearSem sylllabus, @PathVariable Integer id) {
		try {
			YearSem existProduct = sem_service.get(id);
			sem_service.save_YearSem(sylllabus);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/YearSem5/{id}")
	public void delete(@PathVariable Integer id) {
		sem_service.delete(id);
	}

}
