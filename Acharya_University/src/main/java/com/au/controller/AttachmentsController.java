package com.au.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.au.dto.FileRequest;
import com.au.model.Attachments;
import com.au.service.AttachmentsService;

@RestController
@RequestMapping("/api")
public class AttachmentsController {

	Logger log = LoggerFactory.getLogger(AttachmentsController.class);

	@Autowired
	private AttachmentsService as_service;

	@PostMapping("/Attachments")
	public Attachments saveAttachments(@RequestBody @Valid Attachments attachments) throws IOException {
		log.debug("Request {}", attachments);
		return as_service.saveAttachments(attachments);
	}
	
	@PostMapping("/uploadFile")
	public FileRequest uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {
		return as_service.uploadFile1(file);
	}

	@GetMapping("/Attachments")
	public List<Attachments> listAll() {
		return as_service.listAll();

	}

	@GetMapping("/Attachments/{id}")
	public ResponseEntity<Attachments> get(@PathVariable Integer id) {
		try {

			Attachments product = as_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<Attachments>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Attachments>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Attachments/{id}")
	public ResponseEntity<Attachments> update(@RequestBody @Valid Attachments attachments, @PathVariable Integer id) throws IOException {
		try {
			Attachments existProduct = as_service.get(id);
			as_service.saveAttachments(attachments);
			log.debug("Request {}", attachments);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Attachments/{id}")
	public void delete(@PathVariable Integer id) {
		as_service.delete(id);
	}

}
