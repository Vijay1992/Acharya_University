package com.au.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.dto.FeeTemplateAmount;
import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeTemplate;
import com.au.model.FeeTemplateSubAmount;
import com.au.repository.FeeTemplateRepository;
import com.au.repository.FeeTemplateSubAmountRepository;

@Service
@Transactional
public class FeeTemplateSubAmountService {

	@Autowired
	private FeeTemplateSubAmountRepository ftsa_repo;

	@Autowired
	private FeeTemplateRepository ftr_repo;

	public List<FeeTemplateSubAmount> listAll() {
		return ftsa_repo.findAll();
	}

	public FeeTemplateSubAmount saveFeeTemplateSubAmount1(@Valid FeeTemplateSubAmount feetemplatesubamount) {
		return ftsa_repo.save(feetemplatesubamount);

	}

	public List<FeeTemplateSubAmount> saveFeeTemplateSubAmount(List<FeeTemplateSubAmount> feetemplatesubamount) {
		return ftsa_repo.saveAll(feetemplatesubamount);
	}

	public FeeTemplateSubAmount get(Integer id) {
		if (id.equals(0)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return ftsa_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeeTemplateSubAmount id Not Found:" + id));
	}

	public void delete(Integer id) {
		FeeTemplateSubAmount ay = ftsa_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeeTemplateSubAmount id Not Found:" + id));
		ftsa_repo.delete(ay);
	}

	public List<FeeTemplateSubAmount> saveFeeTemplateTotalAmount(FeeTemplateAmount feetemplate) {

		FeeTemplate feetemplate1 = ftr_repo.findByfee_template_id(feetemplate.getFt().getFee_template_id());
		feetemplate1.setFee_year1_amt(feetemplate.getFt().getFee_year1_amt());
		feetemplate1.setFee_year2_amt(feetemplate.getFt().getFee_year2_amt());
		feetemplate1.setFee_year3_amt(feetemplate.getFt().getFee_year3_amt());
		feetemplate1.setFee_year4_amt(feetemplate.getFt().getFee_year4_amt());
		feetemplate1.setFee_year5_amt(feetemplate.getFt().getFee_year5_amt());
		feetemplate1.setFee_year6_amt(feetemplate.getFt().getFee_year6_amt());
		feetemplate1.setFee_year7_amt(feetemplate.getFt().getFee_year7_amt());
		feetemplate1.setFee_year8_amt(feetemplate.getFt().getFee_year8_amt());
		feetemplate1.setFee_year9_amt(feetemplate.getFt().getFee_year9_amt());
		feetemplate1.setFee_year10_amt(feetemplate.getFt().getFee_year10_amt());
		feetemplate1.setFee_year11_amt(feetemplate.getFt().getFee_year11_amt());
		feetemplate1.setFee_year12_amt(feetemplate.getFt().getFee_year12_amt());
		feetemplate1.setFee_year_total_amount(feetemplate.getFt().getFee_year_total_amount());
		ftr_repo.save(feetemplate1);
		return saveFeeTemplateSubAmount(feetemplate.getFtsa());
		// FeeTemplateSubAmount fts = saveFeeTemplateSubAmount(feetemplate.getFtsa());
		// return fts;

	}

	public List<FeeTemplateSubAmount> saveFeeTemplateTotalAmount2( List<FeeTemplateSubAmount> feetemplatesubamount) {
		return ftsa_repo.saveAll(feetemplatesubamount);
	}
}
