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
import com.au.model.Course_Type;
import com.au.service.Course_Type_Service;
@CrossOrigin(origins =  "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class CourseTypeController {

	Logger log = LoggerFactory.getLogger(CourseTypeController.class);
	
	@Autowired
	private Course_Type_Service course_type_service;
	
	@GetMapping("/course_type")
	public List<Course_Type> listAll(){
		return course_type_service.listAll();		
	}
	
	@PostMapping("/course_type")
	public Course_Type save_Course_Type(@RequestBody @Valid Course_Type course_type) {
		return course_type_service.save_Course_Type(course_type);
	}
	
	@GetMapping("/course_type/{id}")
	public ResponseEntity<Course_Type> get(@PathVariable Integer id) {
	    try {
	    	
	    	Course_Type cstype = course_type_service.get(id);
	        return new ResponseEntity<Course_Type>(cstype, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Course_Type>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/course_type/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid Course_Type course, @PathVariable Integer id) {
	    try {
	    	Course_Type existProduct = course_type_service.get(id);
	    	course_type_service.save_Course_Type(course);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/course_type/{id}")
	public void delete(@PathVariable Integer id) {
		course_type_service.delete(id);
	}
}