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

import com.au.model.Academic_year;
import com.au.model.Major_struc;
import com.au.service.Major_struc_Service;

@RestController
@RequestMapping("/api")
public class Major_Struc_Controller {

	@Autowired
	private Major_struc_Service major_service;
	
	@PostMapping("/major_Struc1")
	public Major_struc saveCourse(@RequestBody Major_struc major) {
		return major_service.save_Major_struc(major);
	}
	
	@GetMapping("/major_Struc2")
	public List<Major_struc> listAll(){
		return major_service.listAll();
	}

	
	@GetMapping("/major_Struc3/{id}")
	public ResponseEntity<Major_struc> get(@PathVariable Integer id) {
	    try {	    	
	    	Major_struc major = major_service.get(id);
	        return new ResponseEntity<Major_struc>(major, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Major_struc>(HttpStatus.NOT_FOUND);
	    }      
	}

	
	@PutMapping("/major_Struc4/{id}")
	public ResponseEntity<Academic_year> update(@RequestBody Major_struc major, @PathVariable Integer id) {
	    try {
	    	Major_struc existProduct = major_service.get(id);
	    	major_service.save_Major_struc(major);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/major_Struc5/{id}")
	public void delete(@PathVariable Integer id) {
		major_service.delete(id);
	}
	
	
}
