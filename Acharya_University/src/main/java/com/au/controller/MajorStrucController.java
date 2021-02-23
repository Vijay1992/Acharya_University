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
import com.au.model.MajorStruc;
import com.au.service.MajorStrucService;

@RestController
@RequestMapping("/api")
public class MajorStrucController {

	@Autowired
	private MajorStrucService major_service;
	
	@PostMapping("/MajorStruc1")
	public MajorStruc saveMajorStruc(@RequestBody @Valid MajorStruc major) {
		return major_service.save_MajorStruc(major);
	}
	
	@GetMapping("/MajorStruc2")
	public List<MajorStruc> listAll(){
		return major_service.listAll();
	}

	
	@GetMapping("/MajorStruc3/{id}")
	public ResponseEntity<MajorStruc> get(@PathVariable Integer id) {
	    try {	    	
	    	MajorStruc major = major_service.get(id);
	        return new ResponseEntity<MajorStruc>(major, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<MajorStruc>(HttpStatus.NOT_FOUND);
	    }      
	}

	
	@PutMapping("/MajorStruc4/{id}")
	public ResponseEntity<MajorStruc> update(@RequestBody @Valid MajorStruc major, @PathVariable Integer id) {
	    try {
	    	MajorStruc existProduct = major_service.get(id);
	    	major_service.save_MajorStruc(major);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/MajorStruc5/{id}")
	public void delete(@PathVariable Integer id) {
		major_service.delete(id);
	}
	
	
}
