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
import com.au.model.PGApplicable;
import com.au.service.PGApplicableService;

@RestController
@RequestMapping("/api")
public class PGApplicableController {

	@Autowired
	private PGApplicableService pg_service;
	
	
	Logger log = LoggerFactory.getLogger(PGApplicableController.class);
	
	
	@PostMapping("/PGApplicable")
	public PGApplicable savePGApplicable(@RequestBody @Valid PGApplicable pg) {
		return pg_service.save_PGApplicable(pg);
	}
	
	@GetMapping("/PGApplicable")
	public List<PGApplicable> listAll(){
		return pg_service.listAll();
	}

	
	@GetMapping("/PGApplicable/{id}")
	public ResponseEntity<PGApplicable> get(@PathVariable Integer id) {
	    try {
	    	
	    	PGApplicable product = pg_service.get(id);
	        return new ResponseEntity<PGApplicable>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<PGApplicable>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/PGApplicable/{id}")
	public ResponseEntity<PGApplicable> update(@RequestBody PGApplicable pg, @PathVariable Integer id) {
	    try {
	    	PGApplicable existProduct = pg_service.get(id);
	    	pg_service.save_PGApplicable(pg);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/PGApplicable/{id}")
	public void delete(@PathVariable Integer id) {
		pg_service.delete(id);
	}
	
	
	
}
