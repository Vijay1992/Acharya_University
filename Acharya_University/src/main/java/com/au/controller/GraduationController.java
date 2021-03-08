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

import com.au.model.Graduation;
import com.au.service.Graduation_Service;

@RestController
@RequestMapping("/api")
public class GraduationController {

	
	Logger log = LoggerFactory.getLogger(GraduationController.class);
	
	@Autowired
	private Graduation_Service gs;
	
	@PostMapping("/graduation")
	public Graduation saveGraduation(@RequestBody @Valid Graduation g) {
		return gs.save_Graduation(g);
	}
	
	@GetMapping("/graduation")
	public List<Graduation> listAll(){
		return gs.listAll();
	}

	
	@GetMapping("/graduation/{id}")
	public ResponseEntity<Graduation> get(@PathVariable Integer id) {
	    try {
	    	
	    	Graduation product = gs.get(id);
	        return new ResponseEntity<Graduation>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Graduation>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/graduation/{id}")
	public ResponseEntity<Graduation> update(@RequestBody Graduation g, @PathVariable Integer id) {
	    try {
	    	Graduation existProduct = gs.get(id);
	    	gs.save_Graduation(g);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/graduation/{id}")
	public void delete(@PathVariable Integer id) {
		gs.delete(id);
	}
	
}
