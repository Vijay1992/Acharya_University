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
import com.au.model.JobProfile;
import com.au.service.JobProfileService;

@RestController
@RequestMapping("/api")
public class JobProfileController {
	
	Logger log = LoggerFactory.getLogger(JobProfileController.class);

	@Autowired
	private JobProfileService jps_service;

	@PostMapping("/JobProfile")
	public JobProfile saveAcademicYear(@RequestBody @Valid JobProfile jobprofile) {
		log.debug("Request {}", jobprofile);
		return jps_service.saveJobProfile(jobprofile);
	}

	@GetMapping("/JobProfile")
	public List<JobProfile> listAll() {
		return jps_service.listAll();

	}

	@GetMapping("/JobProfile/{id}")
	public ResponseEntity<JobProfile> get(@PathVariable Integer id) {
		try {

			JobProfile product = jps_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<JobProfile>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<JobProfile>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/JobProfile/{id}")
	public ResponseEntity<JobProfile> update(@RequestBody @Valid JobProfile jobprofile, @PathVariable Integer id) {
		try {
			JobProfile existProduct = jps_service.get(id);
			jps_service.saveJobProfile(jobprofile);
			log.debug("Request {}", jobprofile);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
 
	@DeleteMapping("/JobProfile/{id}")
	public void delete(@PathVariable Integer id) {
		jps_service.delete(id);
	}

}
