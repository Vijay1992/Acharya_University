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
import com.au.model.UserRole;
import com.au.service.UserRoleService;

@RestController
@RequestMapping("/api")
public class UserRoleController {

	Logger log = LoggerFactory.getLogger(UserRoleController.class);

	@Autowired
	private UserRoleService urs_service;

	@PostMapping("/UserRole")
	public ResponseEntity<UserRole> saveUserRoles(@RequestBody @Valid UserRole bs) {
		UserRole bs1 = urs_service.saveUserRole(bs);
		return new ResponseEntity<UserRole>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/UserRole")
	public List<UserRole> listAll() {
		return urs_service.listAll();
	}

	@GetMapping("/UserRole/{id}")
	public ResponseEntity<UserRole> get(@PathVariable Integer id) {
		try {

			UserRole product = urs_service.get(id);
			return new ResponseEntity<UserRole>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/UserRole/{id}")
	public ResponseEntity<UserRole> update(@RequestBody UserRole bs, @PathVariable Integer id) {
		try {
			UserRole existProduct = urs_service.get(id);
			urs_service.saveUserRole(bs);
			return new ResponseEntity<UserRole>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserRole>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/UserRole/{id}")
	public void delete(@PathVariable Integer id) {
		urs_service.delete(id);
	}

}
