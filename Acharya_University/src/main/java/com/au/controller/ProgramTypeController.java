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
import com.au.model.ProgramType;
import com.au.service.ProgramTypeService;
@RestController
@RequestMapping("/api")
public class ProgramTypeController {

	Logger log = LoggerFactory.getLogger(ProgramController.class);
	
	@Autowired
	private ProgramTypeService pr_service;
	
	@PostMapping("/ProgramType")
	public ProgramType saveProgramType(@RequestBody @Valid ProgramType pr) {
		return pr_service.save_ProgramType(pr);
	}
	
	@GetMapping("/ProgramType")
	public List<ProgramType> listAll(){
		return pr_service.listAll();
	}

	
	@GetMapping("/ProgramType/{id}")
	public ResponseEntity<ProgramType> get(@PathVariable Integer id) {
	    try {
	    	
	    	ProgramType p = pr_service.get(id);
	        return new ResponseEntity<ProgramType>(p, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ProgramType>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/ProgramType/{id}")
	public ResponseEntity<ProgramType> update(@RequestBody ProgramType p, @PathVariable Integer id) {
	    try {
	    	ProgramType existProduct = pr_service.get(id);
	    	pr_service.save_ProgramType(p);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/ProgramType/{id}")
	public void delete(@PathVariable Integer id) {
		pr_service.delete(id);
	}
	
}
