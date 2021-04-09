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
import com.au.model.Organization;
import com.au.service.OrganisationService;

@RestController
@RequestMapping("/api")
public class OrganizationController {

	@Autowired
	private OrganisationService org_con;

	@PostMapping("/Organization")
	public Organization saveOrganization(@RequestBody @Valid Organization organization) {
		return org_con.saveOrganisation(organization);
	}

	@GetMapping("/Organization")
	public List<Organization> listAll() {
		return org_con.listAll();
	}

	@GetMapping("/Organization/{id}")
	public ResponseEntity<Organization> get(@PathVariable Integer id) {
		try {

			Organization orga = org_con.get(id);
			return new ResponseEntity<Organization>(orga, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Organization/{id}")
	public ResponseEntity<Organization> update(@RequestBody @Valid Organization organization,
			@PathVariable Integer id) {
		try {
			Organization existProduct = org_con.get(id);
			org_con.saveOrganisation(organization);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Organization/{id}")
	public void delete(@PathVariable Integer id) {
		org_con.delete(id);
	}

}
