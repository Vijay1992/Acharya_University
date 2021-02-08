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
import com.au.model.Credit_System;
import com.au.service.Credit_System_Service;

@RestController
@RequestMapping("/api")
public class Credit_System_Controller {

	@Autowired
	private Credit_System_Service credit_service;
	
	
	@PostMapping("/Credit_System1")
	public Credit_System saveCourse(@RequestBody Credit_System credit_sym) {
		return credit_service.save_Credit_System(credit_sym);
	}
	
	@GetMapping("/Credit_System2")
	public List<Credit_System> listAll(){
		return credit_service.listAll();
	}

	
	@GetMapping("/Credit_System3/{id}")
	public ResponseEntity<Credit_System> get(@PathVariable Integer id) {
	    try {	    	
	    	Credit_System product = credit_service.get(id);
	        return new ResponseEntity<Credit_System>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Credit_System>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Credit_System4/{id}")
	public ResponseEntity<Credit_System> update(@RequestBody Credit_System credit_sym, @PathVariable Integer id) {
	    try {
	    	Credit_System existProduct = credit_service.get(id);
	    	credit_service.save_Credit_System(credit_sym);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Credit_System5/{id}")
	public void delete(@PathVariable Integer id) {
		credit_service.delete(id);
	}
	
}
