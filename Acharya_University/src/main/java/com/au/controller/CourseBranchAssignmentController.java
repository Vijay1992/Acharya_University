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
import com.au.model.CourseBranchAssignment;
import com.au.service.CourseBranchAssignmentService;

@CrossOrigin(origins =  "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class CourseBranchAssignmentController {

	Logger log = LoggerFactory.getLogger(CourseBranchAssignmentController.class);
	
	@Autowired
	private CourseBranchAssignmentService cba_service;
	
	
	@PostMapping("/CourseBranchAssignment")
	public CourseBranchAssignment saveCourse(@RequestBody @Valid CourseBranchAssignment cba) {
		return cba_service.save_CourseBranchAssignment(cba);
	}
	
	@GetMapping("/CourseBranchAssignment")
	public List<CourseBranchAssignment> listAll(){
		return cba_service.listAll();
	}

	
	@GetMapping("/CourseBranchAssignment/{id}")
	public ResponseEntity<CourseBranchAssignment> get(@PathVariable Integer id) {
	    try {
	    	
	    	CourseBranchAssignment cba = cba_service.get(id);
	        return new ResponseEntity<CourseBranchAssignment>(cba, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CourseBranchAssignment>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/CourseBranchAssignment/{id}")
	public ResponseEntity<CourseBranchAssignment> update(@RequestBody CourseBranchAssignment cb, @PathVariable Integer id) {
	    try {
	    	CourseBranchAssignment existProduct = cba_service.get(id);
	    	cba_service.save_CourseBranchAssignment(cb);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/CourseBranchAssignment/{id}")
	public void delete(@PathVariable Integer id) {
		cba_service.delete(id);
	}
	
}
