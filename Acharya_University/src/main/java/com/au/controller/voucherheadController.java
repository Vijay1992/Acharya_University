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
import com.au.model.VoucherHead;
import com.au.service.VoucherHeadService;

@RestController
@RequestMapping("/api")
public class voucherheadController {

	Logger log = LoggerFactory.getLogger(voucherheadController.class);

	@Autowired
	private VoucherHeadService vhs_service;

	@PostMapping("/VoucherHead")
	public VoucherHead saveVoucherHead(@RequestBody @Valid VoucherHead voucherhead) {
		log.debug("Request {}", voucherhead);
		return vhs_service.saveVoucherHead(voucherhead);
	}

	@GetMapping("/VoucherHead")
	public List<VoucherHead> listAll() {
		return vhs_service.listAll();
	}

	@GetMapping("/VoucherHead/{id}")
	public ResponseEntity<VoucherHead> get(@PathVariable Integer id) {
		try {

			VoucherHead product = vhs_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<VoucherHead>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<VoucherHead>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/VoucherHead/{id}")
	public ResponseEntity<VoucherHead> update(@RequestBody @Valid VoucherHead voucherhead, @PathVariable Integer id) {
		try {
			VoucherHead existProduct = vhs_service.get(id);
			vhs_service.saveVoucherHead(voucherhead);
			log.debug("Request {}", voucherhead);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/VoucherHead/{id}")
	public void delete(@PathVariable Integer id) {
		vhs_service.delete(id);
	}

}
