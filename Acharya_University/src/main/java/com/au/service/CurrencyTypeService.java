package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.CurrencyType;
import com.au.repository.CurrencyTypeRepository;

@Service
@Transactional
public class CurrencyTypeService {

	@Autowired
	private CurrencyTypeRepository ctr_repo;

	public List<CurrencyType> listAll() {
		return ctr_repo.findAll();
	}

	public CurrencyType saveCurrencyType(CurrencyType currencytype) {
		return ctr_repo.save(currencytype);
	}

	public CurrencyType get(Integer id) {
		return ctr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CurrencyType id Not Found:" + id));
	}

	public void delete(Integer id) {
		CurrencyType ay = ctr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CurrencyType id Not Found:" + id));
		ctr_repo.delete(ay);
	}

}
