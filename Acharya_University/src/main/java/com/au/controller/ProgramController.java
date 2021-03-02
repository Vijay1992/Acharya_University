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

import com.au.model.Program;
import com.au.model.Schools;
import com.au.service.ProgramService;

@RestController
@RequestMapping("/api")
public class ProgramController {

	Logger log = LoggerFactory.getLogger(ProgramController.class);

	@Autowired
	private ProgramService pro_service;

	@PostMapping("/Program")
	public Program saveCourse(@RequestBody @Valid Program p) {
		return pro_service.save_ProgramType(p);
	}

	@GetMapping("/Program")
	public List<Program> listAll() {
		return pro_service.listAll();
	}

	@GetMapping("/Program/{id}")
	public ResponseEntity<Program> get(@PathVariable Integer id) {
		try {

			Program product = pro_service.get(id);
			return new ResponseEntity<Program>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Program>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Program/{id}")
	public ResponseEntity<Program> update(@RequestBody @Valid Program p, @PathVariable Integer id) {
		try {
			Program existProduct = pro_service.get(id);
			pro_service.save_ProgramType(p);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Program/{id}")
	public void delete(@PathVariable Integer id) {
		pro_service.delete(id);
	}

	@GetMapping("/Program1/{id}")
	public List<Program> get1(@PathVariable Integer id) {
		//try {

			List<Program> school = pro_service.findById(id);
			/*
			 * return new List<Program>(school, HttpStatus.OK); } catch
			 * (NoSuchElementException e) { return new List<Program>(HttpStatus.NOT_FOUND);
			 * }
			 */
			return school;
	}
	
	@GetMapping("pro1/{id}")
	public Integer countRecords(@PathVariable("id")Integer id) {
		return pro_service.countRecords(id);
	}
	
}
