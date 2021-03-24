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
	private VoucherHeadRepository vh_repo;

	public List<VoucherHead> listAll() {
		return vh_repo.findAll();
	}

	public VoucherHead saveVoucherHead(VoucherHead voucherhead) {
		return vh_repo.save(voucherhead);
	}

	public VoucherHead get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return vh_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("VoucherHead id Not Found:" + id));
	}

	public void delete(Integer id) {
		VoucherHead ay = vh_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("VoucherHead id Not Found:" + id));
		vh_repo.delete(ay);
	}

	public List<VoucherHead> findById(Integer school_id) {
		return vh_repo.findById123(school_id);
	}

}
