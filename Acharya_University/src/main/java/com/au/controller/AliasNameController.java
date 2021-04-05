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
import com.au.model.AliasName;
import com.au.service.AliasNameService;

@RestController
@RequestMapping("/api")
public class AliasNameController {

	Logger log = LoggerFactory.getLogger(AliasNameController.class);

	@Autowired
	private AliasNameService ans_service;

	@PostMapping("/AliasName")
	public AliasName saveAliasName(@RequestBody @Valid AliasName aliasname) {
		log.debug("Request {}", aliasname);
		return ans_service.saveAliasName(aliasname);
	}

	@GetMapping("/AliasName")
	public List<AliasName> listAll() {
		return ans_service.listAll();
	}

	@GetMapping("/AliasName/{id}")
	public ResponseEntity<AliasName> get(@PathVariable Integer id) {
		try {

			AliasName product = ans_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<AliasName>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<AliasName>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/AliasName/{id}")
	public ResponseEntity<AliasName> update(@RequestBody @Valid AliasName aliasname, @PathVariable Integer id) {
		try {
			AliasName existProduct = ans_service.get(id);
			ans_service.saveAliasName(aliasname);
			log.debug("Request {}", aliasname);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/AliasName/{id}")
	public void delete(@PathVariable Integer id) {
		ans_service.delete(id);
	}

}












/*
INSERT INTO tbl_au_alias_name(alias_name)
SELECT distinct voucher_head
FROM tbl_au_voucher_head
WHERE NOT EXISTS(SELECT *
FROM tbl_au_alias_name
WHERE (tbl_au_voucher_head.voucher_head=tbl_au_alias_name.alias_name)
)
*/