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
import com.au.model.Group;
import com.au.service.GroupService;

@RestController
@RequestMapping("/api")
public class GroupController {

	Logger log = LoggerFactory.getLogger(GroupController.class);

	@Autowired
	private GroupService gs_service;

	@PostMapping("/Group")
	public Group saveGroup(@RequestBody @Valid Group group) {
		log.debug("Request {}", group);
		return gs_service.saveGroup(group);
	}

	@GetMapping("/Group")
	public List<Group> listAll() {
		return gs_service.listAll();
	}

	@GetMapping("/Group/{id}")
	public ResponseEntity<Group> get(@PathVariable Integer id) {
		try {

			Group product = gs_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<Group>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Group/{id}")
	public ResponseEntity<Group> update(@RequestBody @Valid Group group, @PathVariable Integer id) {
		try {
			Group existProduct = gs_service.get(id);
			gs_service.saveGroup(group);
			log.debug("Request {}", group);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Group/{id}")
	public void delete(@PathVariable Integer id) {
		gs_service.delete(id);
	}

}
