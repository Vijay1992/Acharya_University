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
import com.au.model.CourseAssignment;
import com.au.service.CourseAssignmentService;

@RestController
@RequestMapping("/api")
public class CourseAssignmentController {

	Logger log = LoggerFactory.getLogger(CourseAssignmentController.class);

	@Autowired
	private CourseAssignmentService ca_service;

	@PostMapping("/CourseAssignment")
	public CourseAssignment saveCourseAssignment(@RequestBody @Valid CourseAssignment courseassignment) {
		log.debug("Request {}", courseassignment);
		return ca_service.saveCourseAssignment(courseassignment);
	}

	@GetMapping("/CourseAssignment")
	public List<CourseAssignment> listAll() {
		return ca_service.listAll();
	}

	@GetMapping("/CourseAssignment/{id}")
	public ResponseEntity<CourseAssignment> get(@PathVariable Integer id) {
		try {

			CourseAssignment product = ca_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<CourseAssignment>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<CourseAssignment>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/CourseAssignment/{id}")
	public ResponseEntity<CourseAssignment> update(@RequestBody @Valid CourseAssignment courseassignment,
			@PathVariable Integer id) {
		try {
			CourseAssignment existProduct = ca_service.get(id);
			ca_service.saveCourseAssignment(courseassignment);
			log.debug("Request {}", courseassignment);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/CourseAssignment/{id}")
	public void delete(@PathVariable Integer id) {
		ca_service.delete(id);
	}

}
