
package com.au.controller;

import java.util.HashMap;
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
import com.au.model.FeeTemplate;
import com.au.model.FeeTemplateRequest;
import com.au.service.FeeTemplateService;

@RestController
@RequestMapping("/api")
public class FeeTemplateController {

	@Autowired
	private FeeTemplateService fts_service;

	@PostMapping("/FeeTemplate")
	public List<FeeTemplate> saveFeeTemplate(@RequestBody @Valid FeeTemplateRequest feetemplate) {
		return fts_service.getTemplateName(feetemplate);
	}

	@GetMapping("/FeeTemplate")
	public List<FeeTemplate> listAll() {
		return fts_service.listAll();

	}

	@GetMapping("/FeeTemplate/{id}")
	public ResponseEntity<FeeTemplate> get(@PathVariable Integer id) {
		try {

			FeeTemplate product = fts_service.get(id);
			return new ResponseEntity<FeeTemplate>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<FeeTemplate>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/FeeTemplate/{id}")
	public ResponseEntity<FeeTemplate> update(@RequestBody @Valid FeeTemplate feetemplate, @PathVariable Integer id) {
		try {
			FeeTemplate existProduct = fts_service.get(id);
			fts_service.saveFeeTemplate(feetemplate);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/FeeTemplate/{id}")
	public void delete(@PathVariable Integer id) {
		fts_service.delete(id);
	}

	@GetMapping("FeeTemplateCount/{id1}/{id2}/{id3}") // no of count behalf of schoolid
	public Integer countRecords(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2,
			@PathVariable("id3") Integer id3) {
		return fts_service.countRecords(id1, id2, id3);
	}

	@PostMapping("/checkApi")
	public FeeTemplate saveFeeTemplate(@RequestBody @Valid FeeTemplate board) {
		return fts_service.saveFeeTemplate1(board);
	}
	
	@PostMapping("/FeeTemplateDetails") // (Behalf of fee_template_id)
	public List< HashMap<String,Object>> fetch(@RequestBody List<Integer> fee_template_id) {
		List< HashMap<String,Object>> feetemplate = fts_service.findById(fee_template_id);
		return feetemplate;
	}

}
