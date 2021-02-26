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
import com.au.model.Student;
import com.au.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService stu_service;

	@PostMapping("/Student")
	public Student saveStudent(@RequestBody @Valid Student s) {
		return stu_service.save_Student(s);
	}

	@GetMapping("/Student")
	public List<Student> listAll() {
		return stu_service.listAll();
	}

	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
		try {

			Student product = stu_service.get(id);
			return new ResponseEntity<Student>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> update(@RequestBody @Valid Student s, @PathVariable Integer id) {
		try {
			Student existProduct = stu_service.get(id);
			stu_service.save_Student(s);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Student/{id}")
	public void delete(@PathVariable Integer id) {
		stu_service.delete(id);
	}
}
