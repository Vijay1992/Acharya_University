package com.au.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.VoucherHead;

@Repository
public interface VoucherHeadRepository extends JpaRepository<VoucherHead, Integer> {

	@Query(value = "select * from tbl_au_voucher_head where school_id=?1", nativeQuery = true)
	public List<VoucherHead> findById123(Integer school_id);

}
