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
import com.au.model.FeeAdmissionSubCategory;
import com.au.service.FeeAdmissionSubCategoryService;


@RestController
@RequestMapping("/api")
public class FeeAdmissionSubCategoryController {

	@Autowired
	FeeAdmissionSubCategoryService fee_service;
	
	
	@PostMapping("/FeeAdmissionSubCategory")
	public FeeAdmissionSubCategory saveCourse(@RequestBody @Valid FeeAdmissionSubCategory fee) {
		return fee_service.save_FeeAdmission(fee);
	}
	
	@GetMapping("/FeeAdmissionSubCategory")
	public List<FeeAdmissionSubCategory> listAll(){
		return fee_service.listAll();
	}

	
	@GetMapping("/FeeAdmissionSubCategory/{id}")
	public ResponseEntity<FeeAdmissionSubCategory> get(@PathVariable Integer id) {
	    try {
	    	
	    	FeeAdmissionSubCategory fee = fee_service.get(id);
	        return new ResponseEntity<FeeAdmissionSubCategory>(fee, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<FeeAdmissionSubCategory>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/FeeAdmissionSubCategory/{id}")
	public ResponseEntity<FeeAdmissionSubCategory> update(@RequestBody FeeAdmissionSubCategory fee, @PathVariable Integer id) {
	    try {
	    	FeeAdmissionSubCategory existProduct = fee_service.get(id);
	    	fee_service.save_FeeAdmission(fee);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/FeeAdmissionSubCategory/{id}")
	public void delete(@PathVariable Integer id) {
		fee_service.delete(id);
	}
}
