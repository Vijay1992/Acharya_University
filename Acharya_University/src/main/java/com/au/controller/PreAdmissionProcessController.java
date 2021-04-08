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
import com.au.model.Academic_year;
import com.au.model.PreAdmissionProcess;
import com.au.service.PreAdmissionProcessService;

@RestController
@RequestMapping("/api")
public class PreAdmissionProcessController {

	@Autowired
	private PreAdmissionProcessService p_service;
	
	Logger log = LoggerFactory.getLogger(PreAdmissionProcessController.class);
	
	
	@PostMapping("/PreAdmissionProcess")
	public PreAdmissionProcess savePreAdmissionProcess(@RequestBody @Valid PreAdmissionProcess p) {
		return p_service.save_PreAdmissionProcess(p);
	}
	
	@GetMapping("/PreAdmissionProcess")
	public List<PreAdmissionProcess> listAll(){
		return p_service.listAll();
	}

	
	@GetMapping("/PreAdmissionProcess/{id}")
	public ResponseEntity<PreAdmissionProcess> get(@PathVariable Integer id) {
	    try {
	    	
	    	PreAdmissionProcess product = p_service.get(id);
	        return new ResponseEntity<PreAdmissionProcess>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<PreAdmissionProcess>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/PreAdmissionProcess/{id}")
	public ResponseEntity<Academic_year> update(@RequestBody PreAdmissionProcess p, @PathVariable Integer id) {
	    try {
	    	PreAdmissionProcess existProduct = p_service.get(id);
	    	p_service.save_PreAdmissionProcess(p);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/PreAdmissionProcess/{id}")
	public void delete(@PathVariable Integer id) {
		p_service.delete(id);
	}
	
	
}
