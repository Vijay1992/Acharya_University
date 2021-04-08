package com.au.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.dto.FeeTemplateRequest;
import com.au.exception.ResourceNotFoundException;
import com.au.model.FeeTemplate;
import com.au.repository.FeeTemplateRepository;

@Service
@Transactional
public class FeeTemplateService {

	@Autowired
	private FeeTemplateRepository ft_repo;

	public List<HashMap<String, Object>> listAll( Integer fee_admission_sub_category_id) {
		return ft_repo.findAll1(fee_admission_sub_category_id);
	}

	public List<FeeTemplate> listAll( ) {
		return ft_repo.findAll();
	}
	
	public FeeTemplate saveFeeTemplate(FeeTemplate ft) {
		return ft_repo.save(ft);
	}

	public FeeTemplate get(Integer id) {
		return ft_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeeTemplate Not Found:" + id));
	}

	public void delete(Integer id) {
		FeeTemplate ay = ft_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeeTemplate Not Found:" + id));
		ft_repo.delete(ay);
	}

	/**
	 * @param id
	 * @return {@link AcademicYear}
	 */
	public List<FeeTemplate> getTemplateName(FeeTemplateRequest feetemplaterequest) {
		List<FeeTemplate> lt = new ArrayList<FeeTemplate>();
		
		feetemplaterequest.getFee_admission_sub_category_id().keySet().stream().forEach(a -> {
			FeeTemplate ft = new FeeTemplate();
			String feeTemp = feetemplaterequest.getAc_year().substring(2, 4);
			feeTemp += feetemplaterequest.getProgram_sht().length() > 3
					? feetemplaterequest.getProgram_sht().substring(0, 3)
					: feetemplaterequest.getProgram_sht();
			feeTemp += feetemplaterequest.getFee_admission_category().length() > 1
					? feetemplaterequest.getFee_admission_category().substring(0, 1)
					: feetemplaterequest.getFee_admission_category();
			feeTemp += (ft_repo.findById123(feetemplaterequest.getAc_year_id(),
					feetemplaterequest.getFee_admission_category_id(), feetemplaterequest.getProgram_id()) + 1);
			feeTemp += feetemplaterequest.getFee_admission_sub_category_id().get(a);
			feeTemp += feetemplaterequest.getCurrency_short();
			
			ft.setFee_template_name(feeTemp);
			ft.setAc_year_id(feetemplaterequest.getAc_year_id());
			ft.setSchool_id(feetemplaterequest.getSchool_id());
			ft.setProgram_id(feetemplaterequest.getProgram_id());
			ft.setProgram_specialization_id(feetemplaterequest.getProgram_specialization_id());
			ft.setCurrency_id(feetemplaterequest.getCurrency_id());
			ft.setFee_admission_category_id(feetemplaterequest.getFee_admission_category_id());
			ft.setFee_admission_sub_category_id(a);
			ft.setNationality(feetemplaterequest.getNationality());
			ft.setProgram_type_id(feetemplaterequest.getProgram_type_id());
			ft.setApproved_by(feetemplaterequest.getApproved_by());
			ft.setCreated_by(feetemplaterequest.getCreated_by());
			ft.setModified_by(feetemplaterequest.getModified_by());
			ft.setRemarks(feetemplaterequest.getRemarks());
			ft.setIs_nri(feetemplaterequest.getIs_nri());
			ft.setIs_paid_at_board(feetemplaterequest.getIs_paid_at_board());
			ft.setActive(feetemplaterequest.getActive());
			ft.setRemarks(feetemplaterequest.getRemarks());
			saveFeeTemplate(ft);
			lt.add(ft);
		});
		return lt;

	}

	public Integer countRecords(Integer id1, Integer id2, Integer id3) {
		return ft_repo.findById123(id1, id2, id3);
	}
	
	public FeeTemplate saveFeeTemplate1(FeeTemplate academic) {
		return ft_repo.save(academic);
	}

	public List<String> getTemplates(List<String> fee_template_id) {
		// TODO Auto-generated method stub
		return ft_repo.findByTemplateDetails(fee_template_id);
	}
/*
	public List<HashMap<String , Object>> getTemplates1(List<Integer> fee_template_id){
		return ft_repo.getTemplates(fee_template_id);
	}
*/
	
	public List< HashMap<String,Object>> findById(List<Integer> fee_template_id) {
/*
List<HashMap<String, Object>> l = ft_repo.fetchFeeTemplateDetails(fee_template_id);
		for(HashMap<String, Object> ll:l)
		System.out.println(ll);
*/
		return ft_repo.fetchFeeTemplateDetails(fee_template_id);
		}

}

