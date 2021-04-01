package com.au.controller;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.model.VoucherHead;
import com.au.model.VoucherHeadRequest;
import com.au.service.VoucherHeadService;
@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class VoucherHeadController {

	Logger log = LoggerFactory.getLogger(VoucherHeadController.class);
	
	@Autowired
	private VoucherHeadService vs;
	
	@PostMapping("/VoucherHead")
	public List<VoucherHead> saveVoucherHead(@RequestBody @Valid VoucherHeadRequest  vou) {
//		model.addAttribute("msg", "Voucher Head inserted Successfully");
		return vs.getAllVouchers(vou);
	}

	@PostMapping("/saveVoucherHead")
	public VoucherHead saveVoucherHead(@RequestBody @Valid VoucherHead vou){//Request  vou) {
		return vs.save_VoucherHead(vou);
	}

	@GetMapping("/VoucherHead")
	public List<VoucherHead> listAll(){
		return vs.listAll();
	}

	
	@GetMapping("/VoucherHead/{id}")
	public ResponseEntity<VoucherHead> get(@PathVariable Integer id) {
	    try {
	    	
	    	VoucherHead product = vs.get(id);
	        return new ResponseEntity<VoucherHead>(product, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<VoucherHead>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/VoucherHead/{id}")
	public ResponseEntity<VoucherHead> update(@RequestBody VoucherHead ac_year, @PathVariable Integer id) {
	    try {
	    	VoucherHead existProduct = vs.get(id);
	    	vs.save_VoucherHead(ac_year);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/VoucherHead/{id}")
	public void delete(@PathVariable Integer id) {
		vs.delete(id);
	}
	
	@GetMapping("/FetchVoucherHead/{school_id}")
	 public List<VoucherHead> getVoucherBySchoolId(@PathVariable Integer school_id){

		return vs.getVoucherBySchoolId(school_id);
		
	 }
	/*
	@GetMapping("/FetchVouHead/{vh}/{sid}")
	public List<VoucherHead> findByVouHeadSchoolId(@PathVariable String vh,@PathVariable Integer sid) {
		return vs.findByVouHeadSchoolId(vh,sid);
	}
	*/
	
	@GetMapping("/FetchVouHead/{vh}")
	public List<Integer> findByVouHeadSchoolId(@PathVariable String vh) {
		return vs.findByVouHeadSchoolId(vh);
	}
	
	@GetMapping("/fetch1/{voucher_head}/{sid}")
	public Integer findByVouHeadSchoolId(@PathVariable String voucher_head,@PathVariable Integer sid) {
		return vs.findByVouHeadSchoolId1(voucher_head, sid);
	}
	
}






