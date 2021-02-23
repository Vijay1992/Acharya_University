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
import com.au.model.Year_Sem;
import com.au.service.Year_Sem_Service;

@RestController
@RequestMapping("/api")
public class YearSemController {
	
	Logger log = LoggerFactory.getLogger(YearSemController.class);

	@Autowired
	private Year_Sem_Service sem_service;
	
	@PostMapping("/Year_Sem1")
	public Year_Sem saveCourse(@RequestBody @Valid Year_Sem year) {
		return sem_service.save_Year_Sem(year);
	}
	
	@GetMapping("/Year_Sem2")
	public List<Year_Sem> listAll(){
		return sem_service.listAll();
	}

	
	@GetMapping("/Year_Sem3/{id}")
	public ResponseEntity<Year_Sem> get(@PathVariable Integer id) {
	    try {
	    	
	    	Year_Sem syllabus = sem_service.get(id);
	        return new ResponseEntity<Year_Sem>(syllabus, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Year_Sem>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Year_Sem4/{id}")
	public ResponseEntity<Year_Sem> update(@RequestBody  @Valid Year_Sem sylllabus, @PathVariable Integer id) {
	    try {
	    	Year_Sem existProduct = sem_service.get(id);
	    	sem_service.save_Year_Sem(sylllabus);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Year_Sem5/{id}")
	public void delete(@PathVariable Integer id) {
		sem_service.delete(id);
	}
	
}
