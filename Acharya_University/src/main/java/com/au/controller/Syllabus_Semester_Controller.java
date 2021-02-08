package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.au.model.Syllabus_semester;
import com.au.service.Syllabus_Semester_Service;


@RestController
@RequestMapping("/api")
public class Syllabus_Semester_Controller {

	@Autowired
	private Syllabus_Semester_Service sy_service;
	
	@PostMapping("/Syllabus_Semester1")
	public Syllabus_semester saveCourse(@RequestBody Syllabus_semester sylllabus) {
		return sy_service.save_Syllabus_Semester(sylllabus);
	}
	
	@GetMapping("/Syllabus_Semester2")
	public List<Syllabus_semester> listAll(){
		return sy_service.listAll();
	}

	
	@GetMapping("/Syllabus_Semester3/{id}")
	public ResponseEntity<Syllabus_semester> get(@PathVariable Integer id) {
	    try {
	    	
	    	Syllabus_semester syllabus = sy_service.get(id);
	        return new ResponseEntity<Syllabus_semester>(syllabus, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Syllabus_semester>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Syllabus_Semester4/{id}")
	public ResponseEntity<Syllabus_semester> update(@RequestBody Syllabus_semester sylllabus, @PathVariable Integer id) {
	    try {
	    	Syllabus_semester existProduct = sy_service.get(id);
	    	sy_service.save_Syllabus_Semester(sylllabus);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Syllabus_Semester5/{id}")
	public void delete(@PathVariable Integer id) {
		sy_service.delete(id);
	}
}
