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
import com.au.model.CurrencyType;
import com.au.service.CurrencyTypeService;

@RestController
@RequestMapping("/api")
public class CurrencyTypeController {

	@Autowired
	private CurrencyTypeService cts_service;

	@PostMapping("/CurrencyType")
	public CurrencyType saveCurrencyType(@RequestBody @Valid CurrencyType currencytype) {
		return cts_service.saveCurrencyType(currencytype);
	}

	@GetMapping("/CurrencyType")
	public List<CurrencyType> listAll() {
		return cts_service.listAll();

	}

	@GetMapping("/CurrencyType/{id}")
	public ResponseEntity<CurrencyType> get(@PathVariable Integer id) {
		try {

			CurrencyType product = cts_service.get(id);
			return new ResponseEntity<CurrencyType>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<CurrencyType>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/CurrencyType/{id}")
	public ResponseEntity<CurrencyType> update(@RequestBody @Valid CurrencyType currencytype,
			@PathVariable Integer id) {
		try {
			CurrencyType existProduct = cts_service.get(id);
			cts_service.saveCurrencyType(currencytype);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/CurrencyType/{id}")
	public void delete(@PathVariable Integer id) {
		cts_service.delete(id);
	}

}
