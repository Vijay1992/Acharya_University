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

import com.au.dto.UserRoleRequest;
import com.au.model.UserAuthentication;
import com.au.model.UserRole;
import com.au.service.UserAuthenticationService;

@RestController
@RequestMapping("/api")
public class UserAuthenticationController {

	Logger log = LoggerFactory.getLogger(UserAuthenticationController.class);

	@Autowired
	private UserAuthenticationService uas_service;

	@PostMapping("/UserAuthentication")
	public ResponseEntity<UserAuthentication> saveUserAuthentication(@RequestBody @Valid UserRoleRequest bs) {
		UserAuthentication bs1 = uas_service.saveUserRole(bs);
		return new ResponseEntity<UserAuthentication>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/UserAuthentication")
	public List<UserAuthentication> listAll() {
		return uas_service.listAll();
	}

	@GetMapping("/UserAuthentication/{id}")
	public ResponseEntity<UserAuthentication> get(@PathVariable Integer id) {
		try {

			UserAuthentication product = uas_service.get(id);
			return new ResponseEntity<UserAuthentication>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserAuthentication>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/UserAuthentication/{id}")
	public ResponseEntity<UserAuthentication> update(@RequestBody UserAuthentication bs, @PathVariable Integer id) {
		try {
			UserAuthentication existProduct = uas_service.get(id);
			uas_service.saveUserAuthentication(bs);
			return new ResponseEntity<UserAuthentication>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserAuthentication>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/UserAuthentication/{id}")
	public void delete(@PathVariable Integer id) {
		uas_service.delete(id);
	}

}
