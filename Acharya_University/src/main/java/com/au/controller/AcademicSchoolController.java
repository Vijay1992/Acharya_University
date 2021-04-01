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

import com.au.model.AcademicProgram;
import com.au.model.academic_school;
import com.au.service.AcademicSchoolService;

@RestController
@RequestMapping("/api")
public class AcademicSchoolController {

	@Autowired
	private AcademicSchoolService as_service;
	
	@PostMapping("/academic_school")
	public ResponseEntity<academic_school> saveacademic_school(@RequestBody @Valid academic_school bs) {
		academic_school bs1 = as_service.save_academic_school(bs);
		return new ResponseEntity<academic_school>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/academic_school")
	public List<academic_school> listAll() {
		return as_service.listAll();
	}

	@GetMapping("/academic_school/{id}")
	public ResponseEntity<academic_school> get(@PathVariable Integer id) {
		try {

			academic_school product = as_service.get(id);
			return new ResponseEntity<academic_school>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<academic_school>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/academic_school/{id}")
	public ResponseEntity<academic_school> update(@RequestBody academic_school bs, @PathVariable Integer id) {
		try {
			academic_school existProduct = as_service.get(id);
			as_service.save_academic_school(bs);
			return new ResponseEntity<academic_school>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<academic_school>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/academic_school/{id}")
	public void delete(@PathVariable Integer id) {
		as_service.delete(id);
	}

	
}
