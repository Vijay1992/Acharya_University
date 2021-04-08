package com.au.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.dto.VoucherHeadRequest;
import com.au.exception.ResourceNotFoundException;
import com.au.model.AliasName;
import com.au.model.VoucherHead;
import com.au.repository.AliasNameRepository;
import com.au.repository.VoucherHeadRepository;

@Service
@Transactional
public class VoucherHeadService {
	@Autowired
	private VoucherHeadRepository vou_repo;

	@Autowired
	AliasNameRepository a_repo;

	public List<VoucherHead> listAll() {
		return vou_repo.findAll();
	}

	public List<Integer> getSchoolByVHead(String vh){
		return vou_repo.getSchoolByVHead(vh);
	}
	
	
	public List<VoucherHead> getAllVouchers(VoucherHeadRequest vou) {

		List<VoucherHead> list = new ArrayList<VoucherHead>();

		String vh = vou.getVoucher_head();
		AliasName al1 = new AliasName();

		List<String> list2 = a_repo.getAliasNames();
		if (list2.contains(vh)) {
			System.out.println("already Exist1234");
		} else {
			al1.setAlias_name(vh);
			a_repo.save(al1);
		}

		vou.getSchool_id().keySet().stream().forEach(a -> {
			
			List<Integer> schools = findByVouHeadSchoolId(vou.getVoucher_head());	
			if (schools.contains(a)) {	
				System.out.println("already exist");
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
		});
		return list;
	}

	
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

	public Integer findByVouHeadSchoolId1(String voucher_head, Integer sid) {
		return vou_repo.findByVouHeadSchoolId(voucher_head, sid);
	}
}
