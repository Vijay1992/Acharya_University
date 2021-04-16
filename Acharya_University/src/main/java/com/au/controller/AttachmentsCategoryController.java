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
import com.au.model.AttachmentsCategory;
import com.au.service.AttachmentsCategoryService;

@RestController
@RequestMapping("/api")
public class AttachmentsCategoryController {
	
	Logger log = LoggerFactory.getLogger(AttachmentsCategoryController.class);

	@Autowired
	private AttachmentsCategoryService acs_service;

	@PostMapping("/AttachmentsCategory")
	public AttachmentsCategory saveAttachmentsCategory(@RequestBody @Valid AttachmentsCategory attachmentscategory) {
		log.debug("Request {}", attachmentscategory);
		return acs_service.saveAttachmentsCategory(attachmentscategory);
	}

	@GetMapping("/AttachmentsCategory")
	public List<AttachmentsCategory> listAll() {
		return acs_service.listAll();

	}

	@GetMapping("/AttachmentsCategory/{id}")
	public ResponseEntity<AttachmentsCategory> get(@PathVariable Integer id) {
		try {

			AttachmentsCategory product = acs_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<AttachmentsCategory>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<AttachmentsCategory>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/AttachmentsCategory/{id}")
	public ResponseEntity<AttachmentsCategory> update(@RequestBody @Valid AttachmentsCategory attachmentscategory, @PathVariable Integer id) {
		try {
			AttachmentsCategory existProduct = acs_service.get(id);
			acs_service.saveAttachmentsCategory(attachmentscategory);
			log.debug("Request {}", attachmentscategory);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
 
	@DeleteMapping("/AttachmentsCategory/{id}")
	public void delete(@PathVariable Integer id) {
		acs_service.delete(id);
	}

}
