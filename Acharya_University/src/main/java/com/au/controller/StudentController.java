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
import com.au.model.Student;
import com.au.service.Student_Service;


@RestController
@RequestMapping("/api")
public class StudentController {

	Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private Student_Service stu_service;
	
	@PostMapping("/stu1")
	public Student saveCourse(@RequestBody @Valid Student s) {
		return stu_service.save_Student(s);
	}
	
	@GetMapping("/stu2")
	public List<Student> listAll(){
		return stu_service.listAll();
	}

	
	@GetMapping("/stu3/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
	    try {
	    	
	    	Student product = stu_service.get(id);
	        return new ResponseEntity<Student>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/stu4/{id}")
	public ResponseEntity<Student> update(@RequestBody @Valid Student s, @PathVariable Integer id) {
	    try {
	    	Student existProduct = stu_service.get(id);
	    	stu_service.save_Student(s);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/stu5/{id}")
	public void delete(@PathVariable Integer id) {
		stu_service.delete(id);
	}
}
