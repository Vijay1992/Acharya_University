package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.au.model.CourseBranch;
import com.au.service.CourseBranchService;

@RestController
@RequestMapping("/api")
public class CourseBranchController {

	Logger log = LoggerFactory.getLogger(AcademicYearController.class);

	@Autowired
	private CourseBranchService cb_service;

	@PostMapping("/CourseBranch1")
	public CourseBranch saveCourseBranch(@RequestBody @Valid CourseBranch coursebranch) {
		log.debug("Request {}", coursebranch);
		return cb_service.saveCourseBranch(coursebranch);
	}

	@GetMapping("/CourseBranch2")
	public List<CourseBranch> listAll() {
		return cb_service.listAll();
	}

	@GetMapping("/CourseBranch3/{id}")
	public ResponseEntity<CourseBranch> get(@PathVariable Integer id) {
		try {

			CourseBranch product = cb_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<CourseBranch>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<CourseBranch>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/CourseBranch4/{id}")
	public ResponseEntity<CourseBranch> update(@RequestBody @Valid CourseBranch coursebranch,
			@PathVariable Integer id) {
		try {
			CourseBranch existProduct = cb_service.get(id);
			cb_service.saveCourseBranch(coursebranch);
			log.debug("Request {}", coursebranch);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/CourseBranch5/{id}")
	public void delete(@PathVariable Integer id) {
		cb_service.delete(id);
	}

}
