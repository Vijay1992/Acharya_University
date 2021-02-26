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
import com.au.model.Graduation;
import com.au.service.GraduationService;

@RestController
@RequestMapping("/api")
public class GraduationController {

	Logger log = LoggerFactory.getLogger(GraduationController.class);

	@Autowired
	private GraduationService gr_service;

	@PostMapping("/Graduation")
	public Graduation saveGraduation(@RequestBody @Valid Graduation graduation) {
		log.debug("Request {}", graduation);
		return gr_service.saveGraduation(graduation);
	}

	@GetMapping("/Graduation")
	public List<Graduation> listAll() {
		return gr_service.listAll();
	}

	@GetMapping("/Graduation/{id}")
	public ResponseEntity<Graduation> get(@PathVariable Integer id) {
		try {

			Graduation product = gr_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<Graduation>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Graduation>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Graduation/{id}")
	public ResponseEntity<Graduation> update(@RequestBody @Valid Graduation graduation, @PathVariable Integer id) {
		try {
			Graduation existProduct = gr_service.get(id);
			gr_service.saveGraduation(graduation);
			log.debug("Request {}", graduation);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Graduation/{id}")
	public void delete(@PathVariable Integer id) {
		gr_service.delete(id);
	}

}
