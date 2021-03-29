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

import com.au.model.Board;
import com.au.service.BoardService;

@RestController
@RequestMapping("/api")
public class BoardController {

	Logger log = LoggerFactory.getLogger(AcademicYearController.class);

	@Autowired
	private BoardService bo_service;

	@PostMapping("/Board")
	public Board saveBoard(@RequestBody @Valid Board board) {
		log.debug("Request {}", board);
		return bo_service.saveBoard(board);
	}

	@GetMapping("/Board")
	public List<Board> listAll() {
		return bo_service.listAll();
	}

	@GetMapping("/Board/{id}")
	public ResponseEntity<Board> get(@PathVariable Integer id) {
		try {

			Board product = bo_service.get(id);
			log.debug("Request {}", id);
			return new ResponseEntity<Board>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/Board/{id}")
	public ResponseEntity<Board> update(@RequestBody @Valid Board board, @PathVariable Integer id) {
		try {
			Board existProduct = bo_service.get(id);
			bo_service.saveBoard(board);
			log.debug("Request {}", board);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Board/{id}")
	public void delete(@PathVariable Integer id) {
		bo_service.delete(id);
	}
}