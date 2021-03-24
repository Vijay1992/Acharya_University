package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.au.exception.ResourceNotFoundException;
import com.au.model.Academic_year;
import com.au.model.FeeAdmissionSubCategory;
import com.au.repository.FeeAdmissionSubCategoryRepository;

@Service
@Transactional
public class FeeAdmissionSubCategoryService {

	@Autowired
	private FeeAdmissionSubCategoryRepository fee_repo; 


	public List<FeeAdmissionSubCategory> listAll(){
		return fee_repo.findAll();
	}
	
	public FeeAdmissionSubCategory save_FeeAdmission(FeeAdmissionSubCategory fee) {
		return fee_repo.save(fee);
	}
	
	public FeeAdmissionSubCategory get(Integer id) {
        return fee_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("FeeAdmissionSubCategory  Not Found:"+id));
    }
     
    public void delete(Integer id) {
    	FeeAdmissionSubCategory ay = fee_repo.findById(id)
        		.orElseThrow(()-> new ResourceNotFoundException("FeeAdmissionSubCategory Not Found:"+id));    	
    	fee_repo.delete(ay);
    }

    public List<String> getFeeAdmissionByFeeAdmissionCategoryId(Integer fee_admission_category_id)
    {
    	return fee_repo.getFeeAdmissionByFeeAdmissionCategoryId(fee_admission_category_id);
    }
}
