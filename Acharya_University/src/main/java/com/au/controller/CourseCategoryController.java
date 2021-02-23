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
import com.au.model.CourseCategory;
import com.au.service.CourseCategoryService;

@RestController
@RequestMapping("/api")
public class CourseCategoryController {

	@Autowired
	private CourseCategoryService cs;

	@PostMapping("/CourseCategory1")
	public CourseCategory save_CourseCategory(@RequestBody @Valid CourseCategory CourseCategory) {
		return cs.save_CourseCategory(CourseCategory);
	}

	@GetMapping("/CourseCategory2")
	public List<CourseCategory> listAll() {
		return cs.listAll();
	}

	@GetMapping("/CourseCategory3/{id}")
	public ResponseEntity<CourseCategory> get(@PathVariable Integer id) {
		try {
			CourseCategory cc = cs.get(id);
			return new ResponseEntity<CourseCategory>(cc, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<CourseCategory>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/CourseCategory4/{id}")
	public ResponseEntity<?> update(@RequestBody CourseCategory course, @PathVariable Integer id) {
		try {
			CourseCategory existProduct = cs.get(id);
			cs.save_CourseCategory(course);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/CourseCategory5/{id}")
	public void delete(@PathVariable Integer id) {
		cs.delete(id);
	}

}

/*
 * { "course_name":"Engineering Mathematics I", "course_code":"MAL101",
 * "course_type_id":1, "CourseCategory_id":1, "total_credit":4, "lecture":3,
 * "tutorial":1, "practical":0, "duration":3, "dept_id":1, "cie_marks":40,
 * "see_marks":60 }
 */