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
import com.au.model.CreditSystem;
import com.au.service.CreditSystemService;


@RestController
@RequestMapping("/api")
public class CreditSystemController {

	@Autowired
	private CreditSystemService credit_service;
	
	
	@PostMapping("/CreditSystem1")
	public CreditSystem saveCourse(@RequestBody @Valid CreditSystem credit_sym) {
		return credit_service.save_CreditSystem(credit_sym);
	}
	
	@GetMapping("/CreditSystem2")
	public List<CreditSystem> listAll(){
		return credit_service.listAll();
	}

	
	@GetMapping("/CreditSystem3/{id}")
	public ResponseEntity<CreditSystem> get(@PathVariable Integer id) {
	    try {	    	
	    	CreditSystem product = credit_service.get(id);
	        return new ResponseEntity<CreditSystem>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CreditSystem>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/CreditSystem4/{id}")
	public ResponseEntity<CreditSystem> update(@RequestBody @Valid CreditSystem credit_sym, @PathVariable Integer id) {
	    try {
	    	CreditSystem existProduct = credit_service.get(id);
	    	credit_service.save_CreditSystem(credit_sym);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/CreditSystem5/{id}")
	public void delete(@PathVariable Integer id) {
		credit_service.delete(id);
	}
	
}
