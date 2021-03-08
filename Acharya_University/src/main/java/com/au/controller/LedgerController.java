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

import com.au.model.Ledger;
import com.au.service.LedgerService;

@RestController
@RequestMapping("/api")
public class LedgerController {

	@Autowired
	private LedgerService ls;
	
	
	Logger log = LoggerFactory.getLogger(LedgerController.class);
	
	@PostMapping("/Ledger")
	public Ledger saveLedger(@RequestBody @Valid Ledger l) {
		return ls.save_Ledger(l);
	}
	
	@GetMapping("/Ledger")
	public List<Ledger> listAll(){
		return ls.listAll();
	}

	
	@GetMapping("/Ledger/{id}")
	public ResponseEntity<Ledger> get(@PathVariable Integer id) {
	    try {
	    	
	    	Ledger product = ls.get(id);
	        return new ResponseEntity<Ledger>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Ledger>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/Ledger/{id}")
	public ResponseEntity<Ledger> update(@RequestBody Ledger l, @PathVariable Integer id) {
	    try {
	    	Ledger existProduct = ls.get(id);
	    	ls.save_Ledger(l);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/Ledger/{id}")
	public void delete(@PathVariable Integer id) {
		ls.delete(id);
	}
	
	
	
	@GetMapping("/Ledger1/{grp_id}")
	public List<Ledger> getLedgerByGroupId(@PathVariable Integer grp_id) {
	   return ls.getLedgerByGroupId(grp_id);
	}
	
	
	@GetMapping("/Ledger2/{grp_id}")
	public Integer CountLedgerByGroupId(@PathVariable Integer grp_id) {
		return ls.CountLedgerByGroupId(grp_id);
	}
}
