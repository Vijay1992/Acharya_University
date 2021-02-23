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
import com.au.model.AcademicYear;
import com.au.service.AcademicYearService;

@RestController
@RequestMapping("/api")
public class AcademicYearController {

	Logger log = LoggerFactory.getLogger(AcademicYearController.class);

	@Autowired
	private AcademicYearService ac_service;

	@PostMapping("/AcademicYear1")
	public AcademicYear saveAcademicYear(@RequestBody @Valid AcademicYear ac_year) {
		log.debug("Request {}", ac_year);
		return ac_service.save_Academic_Year(ac_year);
	}

	@GetMapping("/AcademicYear2")
	public List<AcademicYear> listAll() {
		return ac_service.listAll();
	}

	@GetMapping("/AcademicYear3/{id}")
	public ResponseEntity<AcademicYear> get(@PathVariable Integer id) {
		try {

			AcademicYear product = ac_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<AcademicYear>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<AcademicYear>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/AcademicYear4/{id}")
	public ResponseEntity<AcademicYear> update(@RequestBody @Valid AcademicYear ac_year, @PathVariable Integer id) {
		try {
			AcademicYear existProduct = ac_service.get(id);
			ac_service.save_Academic_Year(ac_year);
			log.debug("Request {}", ac_year);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/AcademicYear5/{id}")
	public void delete(@PathVariable Integer id) {
		ac_service.delete(id);
	}

}
