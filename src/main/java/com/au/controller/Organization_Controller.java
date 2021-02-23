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
import com.au.model.Organization;
import com.au.service.Org_service;

@RestController
@RequestMapping("/api")
public class Organization_Controller {

	Logger log = LoggerFactory.getLogger(Organization_Controller.class); 
	
	
	@Autowired
	private Org_service org_service;
	
	/*	@ApiOperation(value = "Create User",notes = "Create New User",tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = " Academic Year created Successfully"),
			@ApiResponse(code = 404,message = "Invalid Data"),
			@ApiResponse(code = 500,message = "INTERNAL SERVER ERROR")				
	})
*/
	@PostMapping("/org1")
	public Organization saveCourse(@RequestBody @Valid Organization org) {
		
		return org_service.save_Org(org);
	}
	
	@GetMapping("/org2")
	public List<Organization> listAll(){
		return org_service.listAll();
	}

	
	@GetMapping("/org3/{id}")
	public ResponseEntity<Organization> get(@PathVariable Integer id) {
	    try {
	    	
	    	Organization org = org_service.get(id);
	        return new ResponseEntity<Organization>(org, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/org4/{id}")
	public ResponseEntity<Organization> update(@RequestBody Organization org, @PathVariable Integer id) {
	    try {
	    	Organization existProduct = org_service.get(id);
	    	org_service.save_Org(org);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/org5/{id}")
	public void delete(@PathVariable Integer id) {
		org_service.delete(id);
	}
	
}
