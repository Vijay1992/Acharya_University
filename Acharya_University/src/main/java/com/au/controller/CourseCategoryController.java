package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.au.model.Course_Category;
import com.au.service.Course_Category_Service;
@CrossOrigin(origins =  "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class CourseCategoryController 
{

	Logger log = LoggerFactory.getLogger(CourseCategoryController.class);
	
	@Autowired
	private Course_Category_Service cs;

	@GetMapping("/couse_category")
	public List<Course_Category> listAll(){
		return cs.listAll();
	}

	@PostMapping("/couse_category")
	public Course_Category save_Course_Category(@RequestBody  @Valid Course_Category course_category) {
		return cs.save_Course_Category(course_category);
	}
	
	@GetMapping("/couse_category/{id}")
	public ResponseEntity<Course_Category> get(@PathVariable Integer id) {
	    try {
	    	Course_Category cc = cs.get(id);
	        return new ResponseEntity<Course_Category>(cc, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Course_Category>(HttpStatus.NOT_FOUND);
	    }      
	}
	

	@PutMapping("/couse_category/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid Course_Category course, @PathVariable Integer id) {
	    try {
	    	Course_Category existProduct = cs.get(id);
	    	cs.save_Course_Category(course);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/couse_category/{id}")
	public void delete(@PathVariable Integer id) {
		cs.delete(id);
	}
	
}



/*
 * { "course_name":"Engineering Mathematics I", "course_code":"MAL101",
 * "course_type_id":1, "course_category_id":1, "total_credit":4, "lecture":3,
 * "tutorial":1, "practical":0, "duration":3, "dept_id":1, "cie_marks":40,
 * "see_marks":60 }
 */