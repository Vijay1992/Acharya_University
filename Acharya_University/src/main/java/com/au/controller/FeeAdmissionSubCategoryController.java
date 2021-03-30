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
import com.au.model.FeeAdmissionSubCategory;
import com.au.service.FeeAdmissionSubCategoryService;

@RestController
@RequestMapping("/api")
public class FeeAdmissionSubCategoryController {
	
	Logger log = LoggerFactory.getLogger(FeeAdmissionSubCategoryController.class);

	@Autowired
	private FeeAdmissionSubCategoryService fasc_service;

	@PostMapping("/FeeAdmissionSubCategory")
	public FeeAdmissionSubCategory saveAdmissionSubCategory(@RequestBody @Valid FeeAdmissionSubCategory feeadmissionsubcategory) {
		log.debug("Request {}", feeadmissionsubcategory);
		return fasc_service.saveAdmissionSubCategory(feeadmissionsubcategory);
	}

	@GetMapping("/FeeAdmissionSubCategory")
	public List<FeeAdmissionSubCategory> listAll() {
		return fasc_service.listAll();
	}

	@GetMapping("/FeeAdmissionSubCategory/{id}")
	public ResponseEntity<FeeAdmissionSubCategory> get(@PathVariable Integer id) {
		try {

			FeeAdmissionSubCategory product = fasc_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<FeeAdmissionSubCategory>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<FeeAdmissionSubCategory>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/FeeAdmissionSubCategory/{id}")
	public ResponseEntity<FeeAdmissionSubCategory> update(@RequestBody @Valid FeeAdmissionSubCategory feeadmissionsubcategory, @PathVariable Integer id) {
		try {
			FeeAdmissionSubCategory existProduct = fasc_service.get(id);
			fasc_service.saveAdmissionSubCategory(feeadmissionsubcategory);
			log.debug("Request {}", feeadmissionsubcategory);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/FeeAdmissionSubCategory/{id}")
	public void delete(@PathVariable Integer id) {
		fasc_service.delete(id);
	}
	
	@GetMapping("/FetchFeeAdmissionSubCategory/{fee_admission_category_id}") // (Behalf of fee_admission_category_id)
	public List<FeeAdmissionSubCategory> fetch(@PathVariable Integer fee_admission_category_id) {
		return fasc_service.findByfetchDetails(fee_admission_category_id);
	}

}
