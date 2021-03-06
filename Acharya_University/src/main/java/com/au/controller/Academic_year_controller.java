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
import com.au.service.Academic_Year_Service;

@RestController
@RequestMapping("/api")
public class Academic_year_controller {

	@Autowired
	private Academic_Year_Service ac_service;
	
	@PostMapping("/academic_year1")
	public Academic_year saveCourse(@RequestBody Academic_year ac_year) {
		return ac_service.save_Academic_Year(ac_year);
	}
	
	@GetMapping("/academic_year2")
	public List<Academic_year> listAll(){
		return ac_service.listAll();
	}

	
	@GetMapping("/academic_year3/{id}")
	public ResponseEntity<Academic_year> get(@PathVariable Integer id) {
	    try {
	    	
	    	Academic_year product = ac_service.get(id);
	        return new ResponseEntity<Academic_year>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Academic_year>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/academic_year4/{id}")
	public ResponseEntity<Academic_year> update(@RequestBody Academic_year ac_year, @PathVariable Integer id) {
	    try {
	    	Academic_year existProduct = ac_service.get(id);
	    	ac_service.save_Academic_Year(ac_year);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/academic_year5/{id}")
	public void delete(@PathVariable Integer id) {
		ac_service.delete(id);
	}
	
	
}
