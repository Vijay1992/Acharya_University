package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;

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
import com.au.model.Course_Category;
import com.au.service.Course_Category_Service;

@RestController
@RequestMapping("/api")
public class Course_Category_Controller 
{

	@Autowired
	private Course_Category_Service cs;

	@GetMapping("/couse_category1")
	public List<Course_Category> listAll(){
		return cs.listAll();
	}

	@PostMapping("/couse_category2")
	public Course_Category save_Course_Category(@RequestBody Course_Category course_category) {
		return cs.save_Course_Category(course_category);
	}
	
	@GetMapping("/couse_category3/{id}")
	public ResponseEntity<Course_Category> get(@PathVariable Integer id) {
	    try {
	    	Course_Category cc = cs.get(id);
	        return new ResponseEntity<Course_Category>(cc, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Course_Category>(HttpStatus.NOT_FOUND);
	    }      
	}
	

	@PutMapping("/couse_category4/{id}")
	public ResponseEntity<?> update(@RequestBody Course_Category course, @PathVariable Integer id) {
	    try {
	    	Course_Category existProduct = cs.get(id);
	    	cs.save_Course_Category(course);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/couse_category5/{id}")
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