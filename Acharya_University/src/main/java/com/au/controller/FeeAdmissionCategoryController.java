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

import com.au.model.FeeAdmissionCategory;
import com.au.service.FeeAdmissionCategoryService;

@RestController
@RequestMapping("/api")
public class FeeAdmissionCategoryController {

	@Autowired
	private FeeAdmissionCategoryService fee_service;
	
	
	@PostMapping("/FeeAdmissionCategory1")
	public FeeAdmissionCategory saveCourse(@RequestBody @Valid FeeAdmissionCategory fee) {
		return fee_service.saveFeeAdmissionCategory(fee);
	}
	
	@GetMapping("/FeeAdmissionCategory2")
	public List<FeeAdmissionCategory> listAll(){
		return fee_service.listAll();
	}

	
	@GetMapping("/FeeAdmissionCategory3/{id}")
	public ResponseEntity<FeeAdmissionCategory> get(@PathVariable Integer id) {
	    try {
	    	
	    	FeeAdmissionCategory fee = fee_service.get(id);
	        return new ResponseEntity<FeeAdmissionCategory>(fee, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<FeeAdmissionCategory>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/FeeAdmissionCategory4/{id}")
	public ResponseEntity<FeeAdmissionCategory> update(@RequestBody FeeAdmissionCategory fee, @PathVariable Integer id) {
	    try {
	    	FeeAdmissionCategory existProduct = fee_service.get(id);
	    	fee_service.saveFeeAdmissionCategory(fee);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/FeeAdmissionCategory5/{id}")
	public void delete(@PathVariable Integer id) {
		fee_service.delete(id);
	}
	
}
