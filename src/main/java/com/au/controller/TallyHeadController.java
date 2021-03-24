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

import com.au.model.TallyHead;
import com.au.service.TallyHeadService;

@RestController
@RequestMapping("/api")
public class TallyHeadController {

	@Autowired
	private TallyHeadService tally_service;

	Logger log = LoggerFactory.getLogger(TallyHeadController.class);
	
	
	@PostMapping("/TallyHead")
	public TallyHead saveTally(@RequestBody @Valid TallyHead tally) {
		return tally_service.save_TallyHead(tally);
	}
	
	@GetMapping("/TallyHead")
	public List<TallyHead> listAll(){
		return tally_service.listAll();
	}

	
	@GetMapping("/TallyHead/{id}")
	public ResponseEntity<TallyHead> get(@PathVariable Integer id) {
	    try {
	    	
	    	TallyHead product = tally_service.get(id);
	        return new ResponseEntity<TallyHead>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<TallyHead>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/TallyHead/{id}")
	public ResponseEntity<TallyHead> update(@RequestBody TallyHead tally, @PathVariable Integer id) {
	    try {
	    	TallyHead existProduct = tally_service.get(id);
	    	tally_service.save_TallyHead(tally);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/TallyHead/{id}")
	public void delete(@PathVariable Integer id) {
		tally_service.delete(id);
	}
}
