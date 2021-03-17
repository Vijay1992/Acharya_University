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

import com.au.model.Academic_year;
//import com.au.model.Course;
import com.au.service.AcademicYearService;

@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AcademicYearController {

	Logger log = LoggerFactory.getLogger(AcademicYearController.class);

	@Autowired
	private AcademicYearService ac_service;
	
/*	@ApiOperation(value = "Create User",notes = "Create New User",tags = {"User Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = " Academic Year created Successfully"),
			@ApiResponse(code = 404,message = "Invalid Data"),
			@ApiResponse(code = 500,message = "INTERNAL SERVER ERROR")				
	})
*/
	
	@PostMapping("/academic_year")
	public Academic_year saveAcademicYear(@RequestBody @Valid Academic_year ac_year) {
		return ac_service.save_Academic_Year(ac_year);
	}
	
	@GetMapping("/academic_year")
	public List<Academic_year> listAll(){
		return ac_service.listAll();
	}

	
	@GetMapping("/academic_year/{id}")
	public ResponseEntity<Academic_year> get(@PathVariable Integer id) {
	    try {
	    	
	    	Academic_year product = ac_service.get(id);
	        return new ResponseEntity<Academic_year>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Academic_year>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/academic_year/{id}")
	public ResponseEntity<Academic_year> update(@RequestBody Academic_year ac_year, @PathVariable Integer id) {
	    try {
	    	Academic_year existProduct = ac_service.get(id);
	    	ac_service.save_Academic_Year(ac_year);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/academic_year/{id}")
	public void delete(@PathVariable Integer id) {
		ac_service.delete(id);
	}
	
	
	/*
	  @GetMapping("FetchAcademicYear/{ac_year_id}") public List<Integer>
	  getAcademicYearByACYearId(@PathVariable Integer ac_year_id) { return
	  (List<Integer>) ac_service.getAcademicYearByACYearId(ac_year_id); }
	 */
	
	@GetMapping("FetchAcademicYear")
	public List<Academic_year> getAcademicYearByACYearId() {
		return  ac_service.getAcademicYearByACYearId();
	}
	
	@GetMapping("academic_year2")
	public Integer countRecords() {
		return ac_service.countRecords();
	}
	
}
