package com.au.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.au.model.AcademicProgram;
import com.au.service.AcademicProgramService;

@RestController
@RequestMapping("/api")
public class AcademicProgramController {

	Logger log = LoggerFactory.getLogger(AcademicProgramController.class);

	private AcademicProgramService ap_service;

	public AcademicProgramController(AcademicProgramService ap_service) {
		super();
		this.ap_service = ap_service;
	}

	@PostMapping("/AcademicProgram")
	public ResponseEntity<AcademicProgram> saveAcademicYear(@RequestBody @Valid AcademicProgram bs) {
		AcademicProgram bs1 = ap_service.save_AcademicProgram(bs);
		return new ResponseEntity<AcademicProgram>(bs1, HttpStatus.CREATED);
	}

	@GetMapping("/AcademicProgram")
	public List<AcademicProgram> listAll() {
		return ap_service.listAll();
	}

	@GetMapping("/AcademicProgram/{id}")
	public ResponseEntity<AcademicProgram> get(@PathVariable Integer id) {
		try {

			AcademicProgram product = ap_service.get(id);
			return new ResponseEntity<AcademicProgram>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<AcademicProgram>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/AcademicProgram/{id}")
	public ResponseEntity<AcademicProgram> update(@RequestBody AcademicProgram bs, @PathVariable Integer id) {
		try {
			AcademicProgram existProduct = ap_service.get(id);
			ap_service.save_AcademicProgram(bs);
			return new ResponseEntity<AcademicProgram>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<AcademicProgram>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/AcademicProgram/{id}")
	public void delete(@PathVariable Integer id) {
		ap_service.delete(id);
	}

	@GetMapping("/fetchAcademicProgram/{program_id}/{ac_year_id}")
	public List<AcademicProgram> getNumOfSemAndYearByProgram_IdAndAcYear_Id(@PathVariable Integer program_id,@PathVariable Integer ac_year_id)
	{
		return ap_service.getNumOfSemAndYearByProgram_IdAndAcYear_Id(program_id, ac_year_id);
	}
}
