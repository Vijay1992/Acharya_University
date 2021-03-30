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
import com.au.model.ProgramSpecilization;
import com.au.service.ProgramSpecilizationService;

@RestController
@RequestMapping("/api")
public class ProgramSpecilizationController {

	Logger log = LoggerFactory.getLogger(ProgramSpecilizationController.class);
	
	@Autowired
	private ProgramSpecilizationService pr_service;
	
	@PostMapping("/ProgramSpecilization")
	public ProgramSpecilization saveProgramSpecilization(@RequestBody @Valid ProgramSpecilization p) {
		return pr_service.save_ProgramSpecilization(p);
	}
	
	@GetMapping("/ProgramSpecilization")
	public List<ProgramSpecilization> listAll(){
		return pr_service.listAll();
	}

	
	@GetMapping("/ProgramSpecilization/{id}")
	public ResponseEntity<ProgramSpecilization> get(@PathVariable Integer id) {
	    try {
	    	
	    	ProgramSpecilization p = pr_service.get(id);
	        return new ResponseEntity<ProgramSpecilization>(p, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ProgramSpecilization>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/ProgramSpecilization/{id}")
	public ResponseEntity<ProgramSpecilization> update(@RequestBody ProgramSpecilization p, @PathVariable Integer id) {
	    try {
	    	ProgramSpecilization existProduct = pr_service.get(id);
	    	pr_service.save_ProgramSpecilization(p);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/ProgramSpecilization/{id}")
	public void delete(@PathVariable Integer id) {
		pr_service.delete(id);
	}
	
	@GetMapping("/FetchProgramSpecialization/{school_id}/{program_id}")      //(Behalf of schoolid and programid)
	public List<ProgramSpecilization> fetch(@PathVariable Integer school_id, @PathVariable Integer program_id) {
	List<ProgramSpecilization> school = (List<ProgramSpecilization>) pr_service.findById(school_id,program_id);
	return school;
	}

	@GetMapping("ProgramSpecializationCount/{school_id}")      //no of count behalf of school_id
	public Integer countRecords(@PathVariable("school_id") Integer id) {
	return pr_service.countRecords(id);
	}
	
	@GetMapping("ProgramSpecializationCount1/{school_id}/{dept_id}/{program_id}/{auid_format}")
	public Integer getProgramSpecilization(@PathVariable Integer school_id,@PathVariable Integer dept_id,
			@PathVariable Integer program_id,@PathVariable String auid_format) {
			
		return pr_service.getProgramSpecilization(school_id, dept_id, program_id, auid_format);
	}
}
