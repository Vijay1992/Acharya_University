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
import com.au.model.AttachmentsSubCategory;
import com.au.service.AttachmentsSubCategoryService;

@RestController
@RequestMapping("/api")
public class AttachmentsSubCategoryController {

	Logger log = LoggerFactory.getLogger(AttachmentsSubCategoryController.class);

	@Autowired
	private AttachmentsSubCategoryService ascs_service;

	@PostMapping("/AttachmentsSubCategory")
	public AttachmentsSubCategory saveAttachmentsSubCategory(
			@RequestBody @Valid AttachmentsSubCategory attachmentssubcategory) {
		log.debug("Request {}", attachmentssubcategory);
		return ascs_service.saveAttachmentsSubCategory(attachmentssubcategory);
	}

	@GetMapping("/AttachmentsSubCategory")
	public List<AttachmentsSubCategory> listAll() {
		return ascs_service.listAll();

	}

	@GetMapping("/AttachmentsSubCategory/{id}")
	public ResponseEntity<AttachmentsSubCategory> get(@PathVariable Integer id) {
		try {

			AttachmentsSubCategory product = ascs_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<AttachmentsSubCategory>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<AttachmentsSubCategory>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/AttachmentsSubCategory/{id}")
	public ResponseEntity<AttachmentsSubCategory> update(
			@RequestBody @Valid AttachmentsSubCategory attachmentssubcategory, @PathVariable Integer id) {
		try {
			AttachmentsSubCategory existProduct = ascs_service.get(id);
			ascs_service.saveAttachmentsSubCategory(attachmentssubcategory);
			log.debug("Request {}", attachmentssubcategory);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/AttachmentsSubCategory/{id}")
	public void delete(@PathVariable Integer id) {
		ascs_service.delete(id);
	}

}
