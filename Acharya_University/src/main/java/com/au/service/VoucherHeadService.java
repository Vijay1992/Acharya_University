package com.au.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.exception.VoucherSchoolFoundException;
import com.au.model.VoucherHead;
import com.au.model.VoucherHeadRequest;
import com.au.repository.VoucherHeadRepository;

@Service
@Transactional
public class VoucherHeadService {

	@Autowired
	private VoucherHeadRepository vou_repo;

	public List<VoucherHead> listAll() {
		return vou_repo.findAll();
	}

	public List<VoucherHead> getAllVouchers(VoucherHeadRequest vou) {
		List<VoucherHead> list = new ArrayList<VoucherHead>();

		vou.getSchool_id().keySet().stream().forEach(a -> {
			System.out.println("=" + a);
			List<Integer> schools = findByVouHeadSchoolId(vou.getVoucher_head());
			System.out.println("==" + schools);
			
		if(schools.contains(a)) {
		//	 if(schools.contains(obj.toString().)){
				throw new VoucherSchoolFoundException(" already exist");
			} else {
				VoucherHead vou1 = new VoucherHead();

				vou1.setVoucher_head(vou.getVoucher_head());
				vou1.setSchool_id(a);
				vou1.setTally_id(vou.getTally_id());
				vou1.setVoucher_type(vou.getVoucher_type());
				vou1.setBudget_head(vou.getBudget_head());
				vou1.setLedger_id(vou.getLedger_id());
				vou1.setCreated_by(vou.getCreated_by());
				vou1.setModified_by(vou.getModified_by());
				vou1.setActive(vou.getActive());

				save_VoucherHead(vou1);
				list.add(vou1);
			}
			
			System.out.println("===" + schools);

		});
		return list;
	}

	/*
	 * public List<VoucherHead> getAllVouchers(VoucherHeadRequest vou) {
	 * List<VoucherHead> list = new ArrayList<VoucherHead>();
	 * System.out.println("--------------------------------------------------------"
	 * );
	 * 
	 * // System.out.println("=====" + vou_repo.findByVouHeadSchoolId(null, null));
	 * 
	 * Map<Integer, String> map = new HashMap<>(); //Integer i =
	 * vou_repo.findByVouHeadSchoolId(vou.getVoucher_head(), vou.getSchool_id());
	 * 
	 * VoucherHead v1 = new VoucherHead();
	 * 
	 * if (vou_repo.findByVouHeadSchoolId(vou.getVoucher_head(),
	 * findByVouHeadSchoolId(vou.getVoucher_head(), vou.getSchool_id()))) >= 1) {
	 * throw new VoucherSchoolFoundException("Voucher School Already Exist"); } else
	 * { vou.getSchool_id().keySet().stream().forEach(a -> { VoucherHead vou1 = new
	 * VoucherHead(); vou1.setVoucher_head(vou.getVoucher_head());
	 * vou1.setSchool_id(a); vou1.setTally_id(vou.getTally_id());
	 * vou1.setVoucher_type(vou.getVoucher_type());
	 * vou1.setBudget_head(vou.getBudget_head());
	 * vou1.setLedger_id(vou.getLedger_id());
	 * vou1.setCreated_by(vou.getCreated_by());
	 * vou1.setModified_by(vou.getModified_by()); vou1.setActive(vou.getActive());
	 * save_VoucherHead(vou1); list.add(vou1); }); } return list; }
	 */
	public VoucherHead save_VoucherHead(VoucherHead voucher) {
		return vou_repo.save(voucher);
	}

	public VoucherHead get(Integer id) {
		return vou_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("VoucherHead Not Found:" + id));
	}

	public void delete(Integer id) {
		VoucherHead ay = vou_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("VoucherHead Not Found:" + id));
		vou_repo.delete(ay);
	}

	public List<VoucherHead> getVoucherBySchoolId(Integer school_id) {
		return vou_repo.getVoucherBySchoolId(school_id);
	}

	public List<Integer> findByVouHeadSchoolId(String vh) {
		return vou_repo.findByVouHeadSchoolId(vh);
	}

}
