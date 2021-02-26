package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

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
import com.au.model.CourseAssignment;
import com.au.service.CourseAssignmentService;

@RestController
@RequestMapping("/api")
public class CourseAssignmentController 
{

	@Autowired
	private CourseAssignmentService cas;		
	
	@PostMapping("/courseassignment")
	public CourseAssignment saveCourse(@RequestBody @Valid CourseAssignment c) {
		return cas.save_CourseAssignment(c);
	}
	
	@GetMapping("/courseassignment")
	public List<CourseAssignment> listAll(){
		return cas.listAll();
	}

	
	@GetMapping("/courseassignment/{id}")
	public ResponseEntity<CourseAssignment> get(@PathVariable Integer id) {
	    try {
	    	
	    	CourseAssignment c = cas.get(id);
	        return new ResponseEntity<CourseAssignment>(c, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CourseAssignment>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/courseassignment/{id}")
	public ResponseEntity<CourseAssignment> update(@RequestBody CourseAssignment c, @PathVariable Integer id) {
	    try {
	    	CourseAssignment existProduct = cas.get(id);
	    	cas.save_CourseAssignment(c);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/courseassignment/{id}")
	public void delete(@PathVariable Integer id) {
		cas.delete(id);
	}
	
	
}
