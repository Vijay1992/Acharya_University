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
import com.au.model.FeeAdmissionCategory;
import com.au.service.FeeAdmissionCategoryService;

@RestController
@RequestMapping("/api")
public class FeeAdmissionCategoryController {

	Logger log = LoggerFactory.getLogger(AcademicYearController.class);

	@Autowired
	private FeeAdmissionCategoryService fac_service;

	@PostMapping("/FeeAdmissionCategory")
	public FeeAdmissionCategory saveFeeAdmissionCategory(
			@RequestBody @Valid FeeAdmissionCategory feeadmissioncategory) {
		log.debug("Request {}", feeadmissioncategory);
		return fac_service.saveFeeAdmissionCategory(feeadmissioncategory);
	}

	@GetMapping("/FeeAdmissionCategory")
	public List<FeeAdmissionCategory> listAll() {
		return fac_service.listAll();
	}

	@GetMapping("/FeeAdmissionCategory/{id}")
	public ResponseEntity<FeeAdmissionCategory> get(@PathVariable Integer id) {
		try {

			FeeAdmissionCategory product = fac_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<FeeAdmissionCategory>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<FeeAdmissionCategory>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/FeeAdmissionCategory/{id}")
	public ResponseEntity<FeeAdmissionCategory> update(@RequestBody @Valid FeeAdmissionCategory feeadmissioncategory,
			@PathVariable Integer id) {
		try {
			FeeAdmissionCategory existProduct = fac_service.get(id);
			fac_service.saveFeeAdmissionCategory(feeadmissioncategory);
			log.debug("Request {}", feeadmissioncategory);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/FeeAdmissionCategory/{id}")
	public void delete(@PathVariable Integer id) {
		fac_service.delete(id);
	}

}
