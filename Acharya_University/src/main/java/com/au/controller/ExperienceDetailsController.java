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
import com.au.model.ExperienceDetails;
import com.au.service.ExperienceDetailsService;

@RestController
@RequestMapping("/api")
public class ExperienceDetailsController {

	Logger log = LoggerFactory.getLogger(ExperienceDetailsController.class);

	@Autowired
	private ExperienceDetailsService eds_service;

	@PostMapping("/ExperienceDetails")
	public List<ExperienceDetails> saveExperienceDetails(@RequestBody @Valid List<ExperienceDetails> experiencedetails) {
		log.debug("Request {}", experiencedetails);
		return eds_service.saveExperienceDetails(experiencedetails);
	}

	@GetMapping("/ExperienceDetails")
	public List<ExperienceDetails> listAll() {
		return eds_service.listAll();

	}

	@GetMapping("/ExperienceDetails/{id}")
	public ResponseEntity<ExperienceDetails> get(@PathVariable Integer id) {
		try {

			ExperienceDetails product = eds_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<ExperienceDetails>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<ExperienceDetails>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/ExperienceDetails/{id}")
	public ResponseEntity<ExperienceDetails> update(@RequestBody @Valid List<ExperienceDetails> experiencedetails,
			@PathVariable Integer id) {
		try {
			ExperienceDetails existProduct = eds_service.get(id);
			eds_service.saveExperienceDetails(experiencedetails);
			log.debug("Request {}", experiencedetails);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/ExperienceDetails/{id}")
	public void delete(@PathVariable Integer id) {
		eds_service.delete(id);
	}

}
