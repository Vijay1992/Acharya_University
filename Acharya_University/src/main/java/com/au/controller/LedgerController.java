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
import com.au.model.Ledger;
import com.au.service.LedgerService;

@RestController
@RequestMapping("/api")
public class LedgerController {

	Logger log = LoggerFactory.getLogger(LedgerController.class);

	@Autowired
	private LedgerService ls_service;

	@PostMapping("/Ledger")
	public Ledger saveCourseBranchAssignment(@RequestBody @Valid Ledger ledger) {
		log.debug("Request {}", ledger);
		return ls_service.saveLedger(ledger);
	}

	@GetMapping("/Ledger")
	public List<Ledger> listAll() {

		return ls_service.listAll();
	}

	@GetMapping("/Ledger/{id}")
	public ResponseEntity<Ledger> get(@PathVariable Integer id) {
		try {

			Ledger product = ls_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<Ledger>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Ledger>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Ledger/{id}")
	public ResponseEntity<Ledger> update(@RequestBody @Valid Ledger ledger, @PathVariable Integer id) {
		try {
			Ledger existProduct = ls_service.get(id);
			ls_service.saveLedger(ledger);
			log.debug("Request {}", ledger);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Ledger/{id}")
	public void delete(@PathVariable Integer id) {
		ls_service.delete(id);
	}

}
