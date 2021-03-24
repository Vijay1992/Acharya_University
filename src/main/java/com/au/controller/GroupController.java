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

import com.au.model.Group;
import com.au.service.GroupService;

@RestController
@RequestMapping("/api")
public class GroupController {

	Logger log = LoggerFactory.getLogger(GroupController.class);

	@Autowired
	private GroupService gs;
	
	@PostMapping("/group")
	public Group saveGroup(@RequestBody @Valid Group g) {
		return gs.save_Group(g);
	}
	
	@GetMapping("/group")
	public List<Group> listAll(){
		return gs.listAll();
	}

	
	@GetMapping("/group/{id}")
	public ResponseEntity<Group> get(@PathVariable Integer id) {
	    try {
	    	
	    	Group g = gs.get(id);
	        return new ResponseEntity<Group>(g, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/group/{id}")
	public ResponseEntity<Group> update(@RequestBody Group g, @PathVariable Integer id) {
	    try {
	    	Group existProduct = gs.get(id);
	    	gs.save_Group(g);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/group/{id}")
	public void delete(@PathVariable Integer id) {
		gs.delete(id);
	}
	
	
	
}
