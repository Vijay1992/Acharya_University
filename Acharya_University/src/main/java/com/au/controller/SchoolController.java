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
import com.au.model.Schools;
import com.au.service.School_Service;

@RestController
@RequestMapping("/api")
public class SchoolController {

	@Autowired
	private School_Service sc_service;

	@PostMapping("/school1")
	public Schools saveCourse(@RequestBody @Valid Schools school) {
		return sc_service.save_School(school);
	}

	@GetMapping("/school2")
	public List<Schools> listAll() {
		return sc_service.listAll();
	}

	@GetMapping("/school3/{id}")
	public ResponseEntity<Schools> get(@PathVariable Integer id) {
		try {

			Schools school = sc_service.get(id);
			return new ResponseEntity<Schools>(school, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Schools>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/school4/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid Schools school, @PathVariable Integer id) {
		try {
			Schools existProduct = sc_service.get(id);
			sc_service.save_School(school);
			return new ResponseEntity<Schools>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/school5/{id}")
	public void delete(@PathVariable Integer id) {
		sc_service.delete(id);
	}
}
