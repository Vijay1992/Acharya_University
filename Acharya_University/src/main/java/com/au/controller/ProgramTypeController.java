package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
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
import com.au.model.ProgramType;
import com.au.service.ProgramTypeService;

@RestController
@RequestMapping("/api")
public class ProgramTypeController {

	@Autowired
	private ProgramTypeService ProgramType_service;

	@PostMapping("/ProgramType")
	public ProgramType saveProgramType(@RequestBody @Valid ProgramType programtype) {
		return ProgramType_service.saveProgramType(programtype);
	}

	@GetMapping("/ProgramType")
	public List<ProgramType> listAll() {
		return ProgramType_service.listAll();
	}

	@GetMapping("/ProgramType/{id}")
	public ResponseEntity<ProgramType> get(@PathVariable Integer id) {
		try {

			ProgramType cstype = ProgramType_service.get(id);
			return new ResponseEntity<ProgramType>(cstype, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ProgramType>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/ProgramType/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid ProgramType program, @PathVariable Integer id) {
		try {
			ProgramType existProduct = ProgramType_service.get(id);
			ProgramType_service.saveProgramType(program);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/ProgramType/{id}")
	public void delete(@PathVariable Integer id) {
		ProgramType_service.delete(id);
	}
}
