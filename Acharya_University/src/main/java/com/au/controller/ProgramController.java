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

import com.au.model.Program;
import com.au.service.Program_Service;

@RestController
@RequestMapping("/api")
public class ProgramController {

	Logger log = LoggerFactory.getLogger(ProgramController.class);

	@Autowired
	private Program_Service pro_service;
	
	@PostMapping("/program")
	public Program saveCourse(@RequestBody @Valid Program p) {
		return pro_service.save_Program(p);
	}
	
	@GetMapping("/program")
	public List<Program> listAll(){
		return pro_service.listAll();
	}

	
	@GetMapping("/program/{id}")
	public ResponseEntity<Program> get(@PathVariable Integer id) {
	    try {
	    	
	    	Program product = pro_service.get(id);
	        return new ResponseEntity<Program>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Program>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/program/{id}")
	public ResponseEntity<Program> update(@RequestBody @Valid Program p, @PathVariable Integer id) {
	    try {
	    	Program existProduct = pro_service.get(id);
	    	pro_service.save_Program(p);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/program/{id}")
	public void delete(@PathVariable Integer id) {
		pro_service.delete(id);
	}
}
