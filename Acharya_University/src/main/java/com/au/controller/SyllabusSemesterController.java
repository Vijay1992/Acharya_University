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
import com.au.model.SyllabusSemester;
import com.au.service.SyllabusSemesterService;

@RestController
@RequestMapping("/api")
public class SyllabusSemesterController {

	@Autowired
	private SyllabusSemesterService sy_service;

	@PostMapping("/SyllabusSemester")
	public SyllabusSemester saveSyllabusSemester(@RequestBody @Valid SyllabusSemester sylllabus) {
		return sy_service.save_SyllabusSemester(sylllabus);
	}

	@GetMapping("/SyllabusSemester")
	public List<SyllabusSemester> listAll() {
		return sy_service.listAll();
	}

	@GetMapping("/SyllabusSemester/{id}")
	public ResponseEntity<SyllabusSemester> get(@PathVariable Integer id) {
		try {

			SyllabusSemester syllabus = sy_service.get(id);
			return new ResponseEntity<SyllabusSemester>(syllabus, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<SyllabusSemester>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/SyllabusSemester/{id}")
	public ResponseEntity<SyllabusSemester> update(@RequestBody @Valid SyllabusSemester sylllabus,
			@PathVariable Integer id) {
		try {
			SyllabusSemester existProduct = sy_service.get(id);
			sy_service.save_SyllabusSemester(sylllabus);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/SyllabusSemester/{id}")
	public void delete(@PathVariable Integer id) {
		sy_service.delete(id);
	}
}
