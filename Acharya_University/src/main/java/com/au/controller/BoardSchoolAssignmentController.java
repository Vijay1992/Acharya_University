package com.au.controller;

import java.util.HashMap;
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
import com.au.model.BoardSchoolAssignment;
import com.au.service.BoardSchoolAssignmentService;

@RestController
@RequestMapping("/api")
public class BoardSchoolAssignmentController {

	@Autowired
	private BoardSchoolAssignmentService bs_service;

	Logger log = LoggerFactory.getLogger(BoardSchoolAssignmentController.class);

	@PostMapping("/BoardSchoolAssignment")
	public BoardSchoolAssignment saveAcademicYear(@RequestBody @Valid BoardSchoolAssignment bs) {
		return bs_service.save_BoardSchoolAssignment(bs);
	}

	@GetMapping("/BoardSchoolAssignment")
	public List<BoardSchoolAssignment> listAll() {
		return bs_service.listAll();
	}

	@GetMapping("/BoardSchoolAssignment/{id}")
	public ResponseEntity<BoardSchoolAssignment> get(@PathVariable Integer id) {
		try {

			BoardSchoolAssignment product = bs_service.get(id);
			return new ResponseEntity<BoardSchoolAssignment>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<BoardSchoolAssignment>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/BoardSchoolAssignment/{id}")
	public ResponseEntity<BoardSchoolAssignment> update(@RequestBody BoardSchoolAssignment bs,
			@PathVariable Integer id) {
		try {
			BoardSchoolAssignment existProduct = bs_service.get(id);
			bs_service.save_BoardSchoolAssignment(bs);
			return new ResponseEntity<BoardSchoolAssignment>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<BoardSchoolAssignment>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/BoardSchoolAssignment/{id}")
	public void delete(@PathVariable Integer id) {
		bs_service.delete(id);
	}

	@GetMapping("/FetchBoardSchoolAssignment/{school_id}") // (Behalf of schoolid)
	public List<HashMap<String, String>> fetch(@PathVariable Integer school_id) {
		return bs_service.findByfetchDetails(school_id);
	}

	@GetMapping("BoardSchoolAssignmentCount/{id}") // no of count behalf of schoolid
	public Integer countRecords(@PathVariable("id") Integer id) {
		return bs_service.countRecords(id);
	}

}