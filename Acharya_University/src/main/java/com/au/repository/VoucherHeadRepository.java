package com.au.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.au.model.AliasName;
import com.au.model.VoucherHead;

@Repository
public interface VoucherHeadRepository extends JpaRepository<VoucherHead, Integer>{

	@Query(value = "SELECT * FROM tbl_au_voucher_head where school_id=?1",nativeQuery = true)
	public List<VoucherHead> getVoucherBySchoolId(Integer school_id);

	/*@Query(value = "SELECT school_id FROM au_db1.tbl_au_voucher_head",nativeQuery = true)
	public List<Integer> getSchools();
	*/
	
	@Query(value = "SELECT count(*) FROM tbl_au_voucher_head where voucher_head=?1 and school_id=?2",nativeQuery = true)
	public Integer findByVouHeadSchoolId(String voucher_head,Integer hashMap);
	
	
	@Query(value = "SELECT school_id FROM tbl_au_voucher_head where voucher_head=?1  ",nativeQuery = true)
	public List<Integer> findByVouHeadSchoolId(String voucher_head);
	

	
/*
	@Query(value = "SELECT count(*) FROM au_db1.tbl_au_voucher_head where voucher_head=?1 and school_id=?2",nativeQuery = true)
	public Integer getVoucherCount(String voucher_head, Integer school_id);
*/	
	/*
	
	@Query(value = " INSERT INTO tbl_au_alias_name(alias_name)\r\n"
			+ "SELECT distinct voucher_head \r\n"
			+ "FROM tbl_au_voucher_head\r\n"
			+ "WHERE NOT EXISTS(SELECT * \r\n"
			+ "                 FROM tbl_au_alias_name \r\n"
			+ "                 WHERE (tbl_au_voucher_head.voucher_head=tbl_au_alias_name.alias_name)",nativeQuery = true)
	public AliasName saveAliasName();
*/	
}

