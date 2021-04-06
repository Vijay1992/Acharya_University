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
import com.au.model.Candidate_Walkin;
import com.au.service.CandidateWalkinService;

@RestController
@RequestMapping("/api")
public class CandidateWalkinController {

	@Autowired
	private CandidateWalkinService can_service;
	
	Logger log = LoggerFactory.getLogger(CandidateWalkinController.class);
	
	@PostMapping("/Candidate_Walkin")
	public Candidate_Walkin saveAcademicYear(@RequestBody @Valid Candidate_Walkin c) {
		return can_service.save_Candidate_Walkin(c);
	}
	
	@GetMapping("/Candidate_Walkin")
	public List<Candidate_Walkin> listAll(){
		return can_service.listAll();
	}

	
	@GetMapping("/Candidate_Walkin/{id}")
	public ResponseEntity<Candidate_Walkin> get(@PathVariable Integer id) {
	    try {
	    	
	    	Candidate_Walkin product = can_service.get(id);
	        return new ResponseEntity<Candidate_Walkin>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Candidate_Walkin>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Candidate_Walkin/{id}")
	public ResponseEntity<Candidate_Walkin> update(@RequestBody Candidate_Walkin c, @PathVariable Integer id) {
	    try {
	    	Candidate_Walkin existProduct = can_service.get(id);
	    	can_service.save_Candidate_Walkin(c);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Candidate_Walkin/{id}")
	public void delete(@PathVariable Integer id) {
		can_service.delete(id);
	}
	
}
