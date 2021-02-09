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

import com.au.model.Program_Master;
import com.au.service.Program_Master_Service;


@RestController
@RequestMapping("/api")
public class Program_Master_Controller {

	@Autowired
	private Program_Master_Service pr_service;
	
	@PostMapping("/program_master1")
	public Program_Master saveCourse(@RequestBody @Valid Program_Master pm) {
		return pr_service.save_Program_Master(pm);
	}
	
	@GetMapping("/program_master2")
	public List<Program_Master> listAll(){
		return pr_service.listAll();
	}

	
	@GetMapping("/program_master3/{id}")
	public ResponseEntity<Program_Master> get(@PathVariable Integer id) {
	    try {
	    	
	    	Program_Master pm = pr_service.get(id);
	        return new ResponseEntity<Program_Master>(pm, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Program_Master>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/program_master4/{id}")
	public ResponseEntity<Program_Master> update(@RequestBody @Valid Program_Master pm, @PathVariable Integer id) {
	    try {
	    	Program_Master existProduct = pr_service.get(id);
	    	pr_service.save_Program_Master(pm);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/program_master5/{id}")
	public void delete(@PathVariable Integer id) {
		pr_service.delete(id);
	}
	
}
