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

import com.au.model.Academic_year;
import com.au.model.ProgramTranscriptDetails;
import com.au.service.ProgramTranscriptDetailsService;

@RestController
@RequestMapping("/api")
public class ProgramTranscriptDetailsController {

	@Autowired
	private ProgramTranscriptDetailsService p_service;
	
	Logger log = LoggerFactory.getLogger(ProgramTranscriptDetailsController.class);
	
	@PostMapping("/ProgramTranscriptDetails")
	public ProgramTranscriptDetails saveAcademicYear(@RequestBody @Valid ProgramTranscriptDetails p) {
		return p_service.saveProgramTranscriptDetails(p);
	}
	
	@GetMapping("/ProgramTranscriptDetails")
	public List<ProgramTranscriptDetails> listAll(){
		return p_service.listAll();
	}

	
	@GetMapping("/ProgramTranscriptDetails/{id}")
	public ResponseEntity<ProgramTranscriptDetails> get(@PathVariable Integer id) {
	    try {
	    	
	    	ProgramTranscriptDetails product = p_service.get(id);
	        return new ResponseEntity<ProgramTranscriptDetails>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ProgramTranscriptDetails>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/ProgramTranscriptDetails/{id}")
	public ResponseEntity<ProgramTranscriptDetails> update(@RequestBody ProgramTranscriptDetails p, @PathVariable Integer id) {
	    try {
	    	ProgramTranscriptDetails existProduct = p_service.get(id);
	    	p_service.saveProgramTranscriptDetails(p);
	        return new ResponseEntity<ProgramTranscriptDetails>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ProgramTranscriptDetails>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/ProgramTranscriptDetails/{id}")
	public void delete(@PathVariable Integer id) {
		p_service.delete(id);
	}
	
	
	@GetMapping("/ProgramTranscriptDetails1/{name}/{program_id}")
	public Integer getProgramTranscriptDetails(@PathVariable String name,@PathVariable Integer program_id) {
		return p_service.getProgramTranscriptDetails(name,program_id);
	}
}
