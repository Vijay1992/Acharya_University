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
import com.au.model.ProgramMaster;
import com.au.service.ProgramMasterService;

@RestController
@RequestMapping("/api")
public class ProgramMasterController {

	@Autowired
	private ProgramMasterService pr_service;

	@PostMapping("/ProgramMaster")
	public ProgramMaster saveProgramMaster(@RequestBody @Valid ProgramMaster pm) {
		return pr_service.save_ProgramMaster(pm);
	}

	@GetMapping("/ProgramMaster")
	public List<ProgramMaster> listAll() {
		return pr_service.listAll();
	}

	@GetMapping("/ProgramMaster/{id}")
	public ResponseEntity<ProgramMaster> get(@PathVariable Integer id) {
		try {

			ProgramMaster pm = pr_service.get(id);
			return new ResponseEntity<ProgramMaster>(pm, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ProgramMaster>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/ProgramMaster/{id}")
	public ResponseEntity<ProgramMaster> update(@RequestBody @Valid ProgramMaster pm, @PathVariable Integer id) {
		try {
			ProgramMaster existProduct = pr_service.get(id);
			pr_service.save_ProgramMaster(pm);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/ProgramMaster/{id}")
	public void delete(@PathVariable Integer id) {
		pr_service.delete(id);
	}

}
