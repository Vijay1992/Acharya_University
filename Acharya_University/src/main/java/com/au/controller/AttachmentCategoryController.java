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

import com.au.model.Academic_year;
import com.au.model.AttachmentCategory;
import com.au.service.AttachmentCategoryService;

@RestController
@RequestMapping("/api")
public class AttachmentCategoryController {

	@Autowired
	private AttachmentCategoryService a_service;
	
	
	Logger log = LoggerFactory.getLogger(AttachmentCategoryController.class);
	
	@PostMapping("/AttachmentCategory")
	public AttachmentCategory saveAttachmentCategory(@RequestBody @Valid AttachmentCategory a) {
		return a_service.saveAttachmentCategory(a);
	}
	
	@GetMapping("/AttachmentCategory")
	public List<AttachmentCategory> listAll(){
		return a_service.listAll();
	}

	
	@GetMapping("/AttachmentCategory/{id}")
	public ResponseEntity<AttachmentCategory> get(@PathVariable Integer id) {
	    try {
	    	
	    	AttachmentCategory product = a_service.get(id);
	        return new ResponseEntity<AttachmentCategory>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<AttachmentCategory>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/AttachmentCategory/{id}")
	public ResponseEntity<AttachmentCategory> update(@RequestBody AttachmentCategory a, @PathVariable Integer id) {
	    try {
	    	AttachmentCategory existProduct = a_service.get(id);
	    	a_service.saveAttachmentCategory(a);
	        return new ResponseEntity<AttachmentCategory>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<AttachmentCategory>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/AttachmentCategory/{id}")
	public void delete(@PathVariable Integer id) {
		a_service.delete(id);
	}
}
