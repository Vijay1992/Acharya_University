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
import com.au.model.Department;
import com.au.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	@GetMapping("/depts1")
	public List<Department> getAllDept() {
		return deptService.listAll();
	}

	@PostMapping("/dept2")
	public Department saveDept(@RequestBody @Valid Department dept) {
		return deptService.save_Department(dept);
	}

	@GetMapping("/dept3/{id}")
	public ResponseEntity<Department> get(@PathVariable Integer id) {
		try {

			Department dept = deptService.get(id);
			return new ResponseEntity<Department>(dept, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/dept4/{id}")
	public ResponseEntity<Department> update(@RequestBody @Valid Department dept, @PathVariable Integer id) {
		try {
			Department existProduct = deptService.get(id);
			deptService.save_Department(dept);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/dept5/{id}")
	public void delete(@PathVariable Integer id) {
		deptService.delete(id);
	}
}
