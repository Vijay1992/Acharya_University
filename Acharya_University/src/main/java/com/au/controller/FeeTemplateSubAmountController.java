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
import com.au.model.FeeTemplateSubAmount;
import com.au.service.FeeTemplateSubAmountService;

@RestController
@RequestMapping("/api")
public class FeeTemplateSubAmountController {

	Logger log = LoggerFactory.getLogger(FeeTemplateSubAmountController.class);

	@Autowired
	private FeeTemplateSubAmountService ftsa_service;

	@PostMapping("/FeeTemplateSubAmount")
	public FeeTemplateSubAmount saveFeeTemplateSubAmount(@RequestBody @Valid FeeTemplateSubAmount feetemplatesubamount) {
		log.debug("Request {}", feetemplatesubamount);
		return ftsa_service.saveFeeTemplateSubAmount(feetemplatesubamount);
	}

	@GetMapping("/FeeTemplateSubAmount")
	public List<FeeTemplateSubAmount> listAll() {
		return ftsa_service.listAll();
	}

	@GetMapping("/FeeTemplateSubAmount/{id}")
	public ResponseEntity<FeeTemplateSubAmount> get(@PathVariable Integer id) {
		try {

			FeeTemplateSubAmount product = ftsa_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<FeeTemplateSubAmount>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<FeeTemplateSubAmount>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/FeeTemplateSubAmount/{id}")
	public ResponseEntity<FeeTemplateSubAmount> update(@RequestBody @Valid FeeTemplateSubAmount feetemplatesubamount,@PathVariable Integer id) {
		try {
			FeeTemplateSubAmount existProduct = ftsa_service.get(id);
			ftsa_service.saveFeeTemplateSubAmount(feetemplatesubamount);
			log.debug("Request {}", feetemplatesubamount);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/FeeTemplateSubAmount/{id}")
	public void delete(@PathVariable Integer id) {
		ftsa_service.delete(id);
	}

}
