package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.exception.ResourceNotFoundException;
import com.au.model.Ledger;
import com.au.repository.LedgerRepository;

@Service
@Transactional
public class LedgerService {
	
	@Autowired
	private LedgerRepository lr_repo;

	public List<Ledger> listAll() {
		return lr_repo.findAll();
	}

	public Ledger saveLedger(Ledger ledger) {
		return lr_repo.save(ledger);
	}

	public Ledger get(Integer id) {
		if (id.equals(5)) {
			throw new RuntimeException("Opps Exception raised....");
		}
		return lr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ledger id Not Found:" + id));
	}

	public void delete(Integer id) {
		Ledger ay = lr_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ledger id Not Found:" + id));
		lr_repo.delete(ay);
	}

	
}
