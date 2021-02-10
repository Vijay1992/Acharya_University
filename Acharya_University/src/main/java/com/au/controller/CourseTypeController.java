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
import com.au.model.CourseType;
import com.au.service.CourseTypeService;


@RestController
@RequestMapping("/api")
public class CourseTypeController {

	@Autowired
	private CourseTypeService CourseType_service;
	
	@PostMapping("/CourseType1")
	public CourseType save_CourseType(@RequestBody @Valid CourseType CourseType) {
		return CourseType_service.save_CourseType(CourseType);
	}
	
	@GetMapping("/CourseType2")
	public List<CourseType> listAll(){
		return CourseType_service.listAll();		
	}
	
	@GetMapping("/CourseType3/{id}")
	public ResponseEntity<CourseType> get(@PathVariable Integer id) {
	    try {
	    	
	    	CourseType cstype = CourseType_service.get(id);
	        return new ResponseEntity<CourseType>(cstype, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CourseType>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/CourseType4/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid CourseType course, @PathVariable Integer id) {
	    try {
	    	CourseType existProduct = CourseType_service.get(id);
	    	CourseType_service.save_CourseType(course);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/CourseType5/{id}")
	public void delete(@PathVariable Integer id) {
		CourseType_service.delete(id);
	}
}
