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
import com.au.model.CourseBranchAssignment;
import com.au.service.CourseBranchAssignmentService;

@RestController
@RequestMapping("/api")
public class CourseBranchAssignmentController {

	Logger log = LoggerFactory.getLogger(AcademicYearController.class);

	@Autowired
	private CourseBranchAssignmentService cba_service;

	@PostMapping("/CourseBranchAssignment1")
	public CourseBranchAssignment saveCourseBranchAssignment(
			@RequestBody @Valid CourseBranchAssignment coursebranchassignment) {
		log.debug("Request {}", coursebranchassignment);
		return cba_service.saveCourseBranchAssignment(coursebranchassignment);
	}

	@GetMapping("/CourseBranchAssignment2")
	public List<CourseBranchAssignment> listAll() {

		return cba_service.listAll();
	}

	@GetMapping("/CourseBranchAssignment3/{id}")
	public ResponseEntity<CourseBranchAssignment> get(@PathVariable Integer id) {
		try {

			CourseBranchAssignment product = cba_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<CourseBranchAssignment>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<CourseBranchAssignment>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/CourseBranchAssignment4/{id}")
	public ResponseEntity<CourseBranchAssignment> update(
			@RequestBody @Valid CourseBranchAssignment coursebranchassignment, @PathVariable Integer id) {
		try {
			CourseBranchAssignment existProduct = cba_service.get(id);
			cba_service.saveCourseBranchAssignment(coursebranchassignment);
			log.debug("Request {}", coursebranchassignment);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/CourseBranchAssignment5/{id}")
	public void delete(@PathVariable Integer id) {
		cba_service.delete(id);
	}

}
