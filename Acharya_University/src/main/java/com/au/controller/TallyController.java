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
import com.au.model.Tally;
import com.au.service.TallyService;

@RestController
@RequestMapping("/api")
public class TallyController {

	Logger log = LoggerFactory.getLogger(TallyController.class);

	@Autowired
	private TallyService ty_service;

	@PostMapping("/Tally")
	public Tally saveTally(@RequestBody @Valid Tally tally) {
		log.debug("Request {}", tally);
		return ty_service.saveTally(tally);
	}

	@GetMapping("/Tally")
	public List<Tally> listAll() {
		return ty_service.listAll();
	}

	@GetMapping("/Tally/{id}")
	public ResponseEntity<Tally> get(@PathVariable Integer id) {
		try {

			Tally product = ty_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<Tally>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Tally>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Tally/{id}")
	public ResponseEntity<Tally> update(@RequestBody @Valid Tally tally, @PathVariable Integer id) {
		try {
			Tally existProduct = ty_service.get(id);
			ty_service.saveTally(tally);
			log.debug("Request {}", tally);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Tally/{id}")
	public void delete(@PathVariable Integer id) {
		ty_service.delete(id);
	}

}
