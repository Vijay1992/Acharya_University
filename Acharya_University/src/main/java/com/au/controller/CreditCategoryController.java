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
import com.au.model.CreditCategory;
import com.au.service.CreditCategoryService;


@RestController
@RequestMapping("/api")
public class CreditCategoryController {

	@Autowired
	private CreditCategoryService credit_service;
	
	@PostMapping("/CreditCategory1")
	public CreditCategory saveCreditCategory(@RequestBody @Valid CreditCategory credit) {
		return credit_service.save_CreditCategory(credit);
	}
	
	@GetMapping("/CreditCategory2")
	public List<CreditCategory> listAll(){
		return credit_service.listAll();
	}

	
	@GetMapping("/CreditCategory3/{id}")
	public ResponseEntity<CreditCategory> get(@PathVariable Integer id) {
	    try {
	    	
	    	CreditCategory credit = credit_service.get(id);
	        return new ResponseEntity<CreditCategory>(credit, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CreditCategory>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/CreditCategory4/{id}")
	public ResponseEntity<CreditCategory> update(@RequestBody @Valid CreditCategory credit, @PathVariable Integer id) {
	    try {
	    	CreditCategory existProduct = credit_service.get(id);
	    	credit_service.save_CreditCategory(credit);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/CreditCategory5/{id}")
	public void delete(@PathVariable Integer id) {
		credit_service.delete(id);
	}
	
}
