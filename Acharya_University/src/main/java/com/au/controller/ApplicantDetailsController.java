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
import com.au.model.ApplicantDetails;
import com.au.service.ApplicantDetailsService;

@RestController
@RequestMapping("/api")
public class ApplicantDetailsController {

	@Autowired
	private ApplicantDetailsService a_service;
	
	Logger log = LoggerFactory.getLogger(ApplicantDetailsController.class);
	
	@PostMapping("/ApplicantDetails")
	public ApplicantDetails saveAcademicYear(@RequestBody @Valid ApplicantDetails a) {
		return a_service.saveApplicantDetails(a);
	}
	
	@GetMapping("/ApplicantDetails")
	public List<ApplicantDetails> listAll(){
		return a_service.listAll();
	}

	
	@GetMapping("/ApplicantDetails/{id}")
	public ResponseEntity<ApplicantDetails> get(@PathVariable Integer id) {
	    try {
	    	
	    	ApplicantDetails product = a_service.get(id);
	        return new ResponseEntity<ApplicantDetails>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ApplicantDetails>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/ApplicantDetails/{id}")
	public ResponseEntity<ApplicantDetails> update(@RequestBody ApplicantDetails a, @PathVariable Integer id) {
	    try {
	    	ApplicantDetails existProduct = a_service.get(id);
	    	a_service.saveApplicantDetails(a);
	        return new ResponseEntity<ApplicantDetails>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ApplicantDetails>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/ApplicantDetails/{id}")
	public void delete(@PathVariable Integer id) {
		a_service.delete(id);
	}
}
