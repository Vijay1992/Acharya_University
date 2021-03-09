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
import com.au.model.Board_School_Assignment;
import com.au.service.BoardSchoolAssignmentService;

@RestController
@RequestMapping("/api")
public class BoardSchoolAssignmentController {

	@Autowired
	private BoardSchoolAssignmentService bs_service;
	
	Logger log = LoggerFactory.getLogger(BoardSchoolAssignmentController.class);
	
	
	@PostMapping("/Board_School_Assignment")
	public Board_School_Assignment saveAcademicYear(@RequestBody @Valid Board_School_Assignment bs) {
		return bs_service.save_Board_School_Assignment(bs);
	}
	
	@GetMapping("/Board_School_Assignment")
	public List<Board_School_Assignment> listAll(){
		return bs_service.listAll();
	}

	
	@GetMapping("/Board_School_Assignment/{id}")
	public ResponseEntity<Board_School_Assignment> get(@PathVariable Integer id) {
	    try {
	    	
	    	Board_School_Assignment product = bs_service.get(id);
	        return new ResponseEntity<Board_School_Assignment>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Board_School_Assignment>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Board_School_Assignment/{id}")
	public ResponseEntity<Board_School_Assignment> update(@RequestBody Board_School_Assignment bs, @PathVariable Integer id) {
	    try {
	    	Board_School_Assignment existProduct = bs_service.get(id);
	    	bs_service.save_Board_School_Assignment(bs);
	        return new ResponseEntity<Board_School_Assignment>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Board_School_Assignment>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Board_School_Assignment/{id}")
	public void delete(@PathVariable Integer id) {
		bs_service.delete(id);
	}
	
	@GetMapping("/Board_School_Assignment1/{id}")
	public Integer getBoardBySchool(@PathVariable Integer id) {
	    	
		return bs_service.getBoardBySchool(id);
	       
	}
	
	@GetMapping("/bs1/{school_id}")
	public List<String> getBoardSchool(@PathVariable Integer school_id){
		return bs_service.getBoardSchool(school_id);
	}
	
	
}



