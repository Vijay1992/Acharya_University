package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.au.model.AttachmentCategory;
import com.au.model.AttachmentSubCategory;
import com.au.service.AttachmentSubCategoryService;

@RestController
@RequestMapping("/api")
public class AttachmentSubCategoryController {

	@Autowired
	private AttachmentSubCategoryService a_service;	
	
	Logger log = LoggerFactory.getLogger(AttachmentSubCategoryController.class);
	
	@PostMapping("/AttachmentSubCategory")
	public AttachmentSubCategory saveAttachmentSubCategory(@RequestBody @Valid AttachmentSubCategory a) {
		return a_service.saveAttachmentSubCategory(a);
	}
	
	@GetMapping("/AttachmentSubCategory")
	public List<AttachmentSubCategory> listAll(){
		return a_service.listAll();
	}
	
	@GetMapping("/AttachmentSubCategory/{id}")
	public ResponseEntity<AttachmentSubCategory> get(@PathVariable Integer id) {
	    try {
	    	
	    	AttachmentSubCategory product = a_service.get(id);
	        return new ResponseEntity<AttachmentSubCategory>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<AttachmentSubCategory>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/AttachmentSubCategory/{id}")
	public ResponseEntity<AttachmentSubCategory> update(@RequestBody AttachmentSubCategory a, @PathVariable Integer id) {
	    try {
	    	AttachmentSubCategory existProduct = a_service.get(id);
	    	a_service.saveAttachmentSubCategory(a);
	        return new ResponseEntity<AttachmentSubCategory>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<AttachmentSubCategory>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/AttachmentSubCategory/{id}")
	public void delete(@PathVariable Integer id) {
		a_service.delete(id);
	}
}
