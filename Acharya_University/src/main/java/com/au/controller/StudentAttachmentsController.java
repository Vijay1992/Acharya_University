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

import com.au.model.CourseBranch;
import com.au.model.StudentAttachments;
import com.au.service.StudentAttachmentsService;

@RestController
@RequestMapping("/api")
public class StudentAttachmentsController {

	@Autowired
	private StudentAttachmentsService s_service;
	
	Logger log = LoggerFactory.getLogger(StudentAttachmentsController.class);
	
	@PostMapping("/StudentAttachments")
	public StudentAttachments saveStudentAttachments(@RequestBody @Valid StudentAttachments s) {
		
		return s_service.saveStudentAttachments(s);
	}
	
	@GetMapping("/StudentAttachments")
	public List<StudentAttachments> listAll(){
		return s_service.listAll();
	}

	
	@GetMapping("/StudentAttachments/{id}")
	public ResponseEntity<StudentAttachments> get(@PathVariable Integer id) {
	    try {
	    	
	    	StudentAttachments cb = s_service.get(id);
	        return new ResponseEntity<StudentAttachments>(cb, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<StudentAttachments>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/StudentAttachments/{id}")
	public ResponseEntity<StudentAttachments> update(@RequestBody StudentAttachments s, @PathVariable Integer id) {
	    try {
	    	StudentAttachments existProduct = s_service.get(id);
	    	s_service.saveStudentAttachments(s);
	        return new ResponseEntity<StudentAttachments>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<StudentAttachments>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/StudentAttachments/{id}")
	public void delete(@PathVariable Integer id) {
		s_service.delete(id);
	}
	
	
}
