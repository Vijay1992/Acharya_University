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
import com.au.model.Roles;
import com.au.service.RolesService;

@RestController
@RequestMapping("/api")
public class RolesController {

	Logger log = LoggerFactory.getLogger(RolesController.class);

	@Autowired
	private RolesService rs_service;

	@PostMapping("/Roles")
	public ResponseEntity<Roles> saveRoles(@RequestBody @Valid Roles bs) {
		Roles bs1 = rs_service.saveRoles(bs);
		return new ResponseEntity<Roles>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/Roles")
	public List<Roles> listAll() {
		return rs_service.listAll();
	}

	@GetMapping("/Roles/{id}")
	public ResponseEntity<Roles> get(@PathVariable Integer id) {
		try {

			Roles product = rs_service.get(id);
			return new ResponseEntity<Roles>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Roles/{id}")
	public ResponseEntity<Roles> update(@RequestBody Roles bs, @PathVariable Integer id) {
		try {
			Roles existProduct = rs_service.get(id);
			rs_service.saveRoles(bs);
			return new ResponseEntity<Roles>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Roles/{id}")
	public void delete(@PathVariable Integer id) {
		rs_service.delete(id);
	}

}
