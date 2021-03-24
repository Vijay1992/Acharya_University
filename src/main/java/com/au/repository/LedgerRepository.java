package com.au.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.Ledger;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger	, Integer>{

	@Query(value = "SELECT * FROM tbl_au_ledger where group_id=?1",nativeQuery = true)
	public List<Ledger> getLedgerByGroupId(Integer grp_id);
	

	@Query(value = "SELECT count(ledger_id)  FROM tbl_au_ledger where group_id=?1",nativeQuery = true)
	public Integer CountLedgerByGroupId(Integer grp_id);
	
}
