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
import com.au.model.ProgramSpecialization;
import com.au.service.ProgramSpecializationService;

@RestController
@RequestMapping("/api")
public class ProgramSpecializationController {

	Logger log = LoggerFactory.getLogger(ProgramSpecializationController.class);

	@Autowired
	private ProgramSpecializationService pss_service;

	@PostMapping("/ProgramSpecialization")
	public ProgramSpecialization saveAcademicYear(@RequestBody @Valid ProgramSpecialization ac_year) {
		log.debug("Request {}", ac_year);
		return pss_service.saveProgramSpecialization(ac_year);
	}

	@GetMapping("/ProgramSpecialization")
	public List<ProgramSpecialization> listAll() {
		return pss_service.listAll();
	}

	@GetMapping("/ProgramSpecialization/{id}")
	public ResponseEntity<ProgramSpecialization> get(@PathVariable Integer id) {
		try {

			ProgramSpecialization product = pss_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<ProgramSpecialization>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<ProgramSpecialization>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/ProgramSpecialization/{id}")
	public ResponseEntity<ProgramSpecialization> update(@RequestBody @Valid ProgramSpecialization ac_year,
			@PathVariable Integer id) {
		try {
			ProgramSpecialization existProduct = pss_service.get(id);
			pss_service.saveProgramSpecialization(ac_year);
			log.debug("Request {}", ac_year);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/ProgramSpecialization/{id}")
	public void delete(@PathVariable Integer id) {
		pss_service.delete(id);
	}
	
	@GetMapping("/FetchProgramSpecialization/{id1}/{id2}")      //(Behalf of schoolid and programid)
	public List<ProgramSpecialization> fetch(@PathVariable Integer id1, @PathVariable Integer id2) {
		List<ProgramSpecialization> school = pss_service.findById(id1,id2);
		return school;
	}

	@GetMapping("ProgramSpecializationCount/{id}")      //no of count behalf of schoolid
	public Integer countRecords(@PathVariable("id") Integer id) {
		return pss_service.countRecords(id);
	}
	
}
