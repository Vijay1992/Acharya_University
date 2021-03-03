package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class VoucherHeadController {

	Logger log = LoggerFactory.getLogger(VoucherHeadController.class);
	
	@Autowired
	private VoucherHeadService vs;
	
	@PostMapping("/VoucherHead")
	public VoucherHead saveCourse(@RequestBody @Valid VoucherHead ac_year) {
		return vs.save_VoucherHead(ac_year);
	}
	
	@GetMapping("/VoucherHead")
	public List<VoucherHead> listAll(){
		return vs.listAll();
	}

	
	@GetMapping("/VoucherHead/{id}")
	public ResponseEntity<VoucherHead> get(@PathVariable Integer id) {
	    try {
	    	
	    	VoucherHead product = vs.get(id);
	        return new ResponseEntity<VoucherHead>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<VoucherHead>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/VoucherHead/{id}")
	public ResponseEntity<VoucherHead> update(@RequestBody VoucherHead ac_year, @PathVariable Integer id) {
	    try {
	    	VoucherHead existProduct = vs.get(id);
	    	vs.save_VoucherHead(ac_year);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/VoucherHead/{id}")
	public void delete(@PathVariable Integer id) {
		vs.delete(id);
	}
	
}
