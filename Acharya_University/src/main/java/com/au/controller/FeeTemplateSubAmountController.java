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

import com.au.dto.FeeTemplateAmount;
import com.au.model.FeeTemplateSubAmount;
import com.au.service.FeeTemplateSubAmountService;

@RestController
@RequestMapping("/api")
public class FeeTemplateSubAmountController {

	@Autowired
	private FeeTemplateSubAmountService fee_service;
	
	Logger log = LoggerFactory.getLogger(FeeTemplateSubAmountController.class);
	
	/*@PostMapping("/FeeTemplateSubAmount")
	public ResponseEntity<FeeTemplateSubAmount> saveAcademicYear(@RequestBody @Valid FeeTemplateSubAmount bs) {
		FeeTemplateSubAmount bs1 = fee_service.save_FeeTemplateSubAmount(bs);
		return new ResponseEntity<FeeTemplateSubAmount>(bs1, HttpStatus.CREATED);
	}*/
	
	@PostMapping("/FeeTemplateSubAmount")
	public FeeTemplateSubAmount saveFeeTemplateSubAmount(@RequestBody @Valid FeeTemplateAmount feetemplatesubamount) {
	log.debug("Request {}", feetemplatesubamount);
	return fee_service.saveFeeTemplateTotalAmount(feetemplatesubamount);
	}

	@GetMapping("/FeeTemplateSubAmount")
	public List<FeeTemplateSubAmount> listAll() {
		return fee_service.listAll();
	}

	@GetMapping("/FeeTemplateSubAmount/{id}")
	public ResponseEntity<FeeTemplateSubAmount> get(@PathVariable Integer id) {
		try {

			FeeTemplateSubAmount product = fee_service.get(id);
			return new ResponseEntity<FeeTemplateSubAmount>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<FeeTemplateSubAmount>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/FeeTemplateSubAmount/{id}")
	public ResponseEntity<FeeTemplateSubAmount> update(@RequestBody FeeTemplateSubAmount bs, @PathVariable Integer id) {
		try {
			FeeTemplateSubAmount existProduct = fee_service.get(id);
			fee_service.saveFeeTemplateSubAmount(bs);
			return new ResponseEntity<FeeTemplateSubAmount>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<FeeTemplateSubAmount>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/FeeTemplateSubAmount/{id}")
	public void delete(@PathVariable Integer id) {
		fee_service.delete(id);
	}
}
