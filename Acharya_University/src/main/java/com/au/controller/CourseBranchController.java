package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.model.CourseBranch;
import com.au.service.CourseBranchService;
@CrossOrigin(origins =  "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class CourseBranchController {

	Logger log = LoggerFactory.getLogger(CourseBranchController.class);
	
	@Autowired
	private CourseBranchService cb_service;
	
	@PostMapping("/coursebranch")
	public CourseBranch saveCourseBranch(@RequestBody @Valid CourseBranch cb) {
		return cb_service.save_CourseBranch(cb);
	}
	
	@GetMapping("/coursebranch")
	public List<CourseBranch> listAll(){
		return cb_service.listAll();
	}

	
	@GetMapping("/coursebranch/{id}")
	public ResponseEntity<CourseBranch> get(@PathVariable Integer id) {
	    try {
	    	
	    	CourseBranch cb = cb_service.get(id);
	        return new ResponseEntity<CourseBranch>(cb, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CourseBranch>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/coursebranch/{id}")
	public ResponseEntity<CourseBranch> update(@RequestBody CourseBranch cb, @PathVariable Integer id) {
	    try {
	    	CourseBranch existProduct = cb_service.get(id);
	    	cb_service.save_CourseBranch(cb);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/coursebranch/{id}")
	public void delete(@PathVariable Integer id) {
		cb_service.delete(id);
	}
	
	
}
