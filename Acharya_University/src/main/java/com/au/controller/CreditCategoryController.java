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

import com.au.model.Credit_Category;
import com.au.service.Credit_Category_Service;

@RestController
@RequestMapping("/api")
public class CreditCategoryController {

	@Autowired
	private Credit_Category_Service credit_service;
	
	@PostMapping("/Credit_Category1")
	public Credit_Category saveCourse(@RequestBody @Valid Credit_Category credit) {
		return credit_service.save_Credit_Category(credit);
	}
	
	@GetMapping("/Credit_Category2")
	public List<Credit_Category> listAll(){
		return credit_service.listAll();
	}

	
	@GetMapping("/Credit_Category3/{id}")
	public ResponseEntity<Credit_Category> get(@PathVariable Integer id) {
	    try {
	    	
	    	Credit_Category credit = credit_service.get(id);
	        return new ResponseEntity<Credit_Category>(credit, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Credit_Category>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Credit_Category4/{id}")
	public ResponseEntity<Credit_Category> update(@RequestBody @Valid Credit_Category credit, @PathVariable Integer id) {
	    try {
	    	Credit_Category existProduct = credit_service.get(id);
	    	credit_service.save_Credit_Category(credit);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Credit_Category5/{id}")
	public void delete(@PathVariable Integer id) {
		credit_service.delete(id);
	}
	
}
