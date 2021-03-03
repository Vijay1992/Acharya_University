package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.VoucherHead;
import com.au.repository.VoucherHeadRepository;

@Service
@Transactional
public class VoucherHeadService {

	@Autowired
	private VoucherHeadRepository vou_repo;

	
	public List<VoucherHead> listAll(){
		return vou_repo.findAll();
	}
	
	public VoucherHead save_VoucherHead(VoucherHead academic) {
		return vou_repo.save(academic);
	}
	
	public VoucherHead get(Integer id) {
        return vou_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("VoucherHead Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	VoucherHead ay = vou_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("VoucherHead Not Found:"+id));    	
    	vou_repo.delete(ay);
    }
}
