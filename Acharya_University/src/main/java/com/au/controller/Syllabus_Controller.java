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

import com.au.model.Syllabus;
import com.au.service.Syllabus_Service;

@RestController
@RequestMapping("/api")
public class Syllabus_Controller {

	@Autowired
	private Syllabus_Service sy_service;
		
	@PostMapping("/syllabus1")
	public Syllabus saveCourse(@RequestBody Syllabus syllabus) {
		return sy_service.save_Syllabus(syllabus);
	}
	
	@GetMapping("/syllabus2")
	public List<Syllabus> listAll(){
		return sy_service.listAll();
	}

	
	@GetMapping("/syllabus3/{id}")
	public ResponseEntity<Syllabus> get(@PathVariable Integer id) {
	    try {
	    	
	    	Syllabus product = sy_service.get(id);
	        return new ResponseEntity<Syllabus>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Syllabus>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/syllabus4/{id}")
	public ResponseEntity<Syllabus> update(@RequestBody Syllabus syllabus, @PathVariable Integer id) {
	    try {
	    	Syllabus existProduct = sy_service.get(id);
	    	sy_service.save_Syllabus(syllabus);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/syllabus5/{id}")
	public void delete(@PathVariable Integer id) {
		sy_service.delete(id);
	}
	
	
}
