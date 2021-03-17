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
import com.au.model.Currency_Type;
import com.au.service.CurrencyTypeService;

@RestController
@RequestMapping("/api")
public class CurrencyTypeController {

	@Autowired
	private CurrencyTypeService ct_service;
	
	Logger log = LoggerFactory.getLogger(CurrencyTypeController.class);
	
	@PostMapping("/CurrencyType")
	public ResponseEntity<Currency_Type> saveAcademicYear(@RequestBody @Valid Currency_Type c) {
		Currency_Type bs1 = ct_service.saveCurrency_Type(c);
		return new ResponseEntity<Currency_Type>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/CurrencyType")
	public List<Currency_Type> listAll() {
		return ct_service.listAll();
	}

	@GetMapping("/CurrencyType/{id}")
	public ResponseEntity<Currency_Type> get(@PathVariable Integer id) {
		try {

			Currency_Type product = ct_service.get(id);
			return new ResponseEntity<Currency_Type>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Currency_Type>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/CurrencyType/{id}")
	public ResponseEntity<Currency_Type> update(@RequestBody Currency_Type c, @PathVariable Integer id) {
		try {
			Currency_Type existProduct = ct_service.get(id);
			ct_service.saveCurrency_Type(c);
			return new ResponseEntity<Currency_Type>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Currency_Type>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/CurrencyType/{id}")
	public void delete(@PathVariable Integer id) {
		ct_service.delete(id);
	}
	
}

