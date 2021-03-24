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
import com.au.model.AliasName;
import com.au.service.AliasNameService;

@RestController
@RequestMapping("/api")
public class AliasNameController {

	@Autowired
	private AliasNameService a_service;
	
	Logger log = LoggerFactory.getLogger(AliasNameController.class);
	
	@PostMapping("/AliasName")
	public ResponseEntity<AliasName> saveAliasName(@RequestBody @Valid AliasName bs) {
		AliasName bs1 = a_service.save_AliasName(bs);
		return new ResponseEntity<AliasName>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/AliasName")
	public List<AliasName> listAll() {
		return a_service.listAll();
	}

	@GetMapping("/AliasName/{id}")
	public ResponseEntity<AliasName> get(@PathVariable Integer id) {
		try {

			AliasName product = a_service.get(id);
			return new ResponseEntity<AliasName>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<AliasName>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/AliasName/{id}")
	public ResponseEntity<AliasName> update(@RequestBody AliasName bs, @PathVariable Integer id) {
		try {
			AliasName existProduct = a_service.get(id);
			a_service.save_AliasName(bs);
			return new ResponseEntity<AliasName>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<AliasName>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/AliasName/{id}")
	public void delete(@PathVariable Integer id) {
		a_service.delete(id);
	}
}
