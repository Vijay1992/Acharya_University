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
import com.au.model.Course;
import com.au.service.Course_Service;

@RestController
@RequestMapping("/api")
public class Course_Controller {

	@Autowired
	private Course_Service course_service;

	@PostMapping("/course1")
	public Course saveCourse(@RequestBody @Valid Course course) {
		return course_service.saveCourse(course);
	}

	@GetMapping("/course2")
	public List<Course> listAll() {
		return course_service.listAll();
	}

	@GetMapping("/course3/{id}")
	public ResponseEntity<Course> get(@PathVariable Integer id) {
		try {

			Course product = course_service.get(id);
			return new ResponseEntity<Course>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/course4/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid Course course, @PathVariable Integer id) {
		try {
			Course existProduct = course_service.get(id);
			course_service.saveCourse(course);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/course5/{id}")
	public void delete(@PathVariable Integer id) {
		course_service.delete(id);
	}
}
