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
import com.au.model.EducationDetails;
import com.au.service.EducationDetailsService;

@RestController
@RequestMapping("/api")
public class EducationDetailsController {

	Logger log = LoggerFactory.getLogger(EducationDetailsController.class);

	@Autowired
	private EducationDetailsService eds_service;

	@PostMapping("/EducationDetails")
	public List<EducationDetails> saveEducationDetails(@RequestBody @Valid List<EducationDetails> educationdetails) {
		log.debug("Request {}", educationdetails);
		return eds_service.saveEducationDetails(educationdetails);
	}

	@GetMapping("/EducationDetails")
	public List<EducationDetails> listAll() {
		return eds_service.listAll();

	}

	@GetMapping("/EducationDetails/{id}")
	public ResponseEntity<EducationDetails> get(@PathVariable Integer id) {
		try {

			EducationDetails product = eds_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<EducationDetails>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<EducationDetails>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/EducationDetails/{id}")
	public ResponseEntity<EducationDetails> update(@RequestBody @Valid EducationDetails educationdetails,
			@PathVariable Integer id) {
		try {
			EducationDetails existProduct = eds_service.get(id);
			eds_service.saveEducationDetails1(educationdetails);
			log.debug("Request {}", educationdetails);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/EducationDetails/{id}")
	public void delete(@PathVariable Integer id) {
		eds_service.delete(id);
	}

}
