package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.au.model.FeeTemplate;

@Repository
public interface FeeTemplateRepository extends JpaRepository<FeeTemplate, Integer>{

	@Query(value = "select count(*) from tbl_au_fee_template where ac_year_id = ?1 and program_id=?2 and fee_admission_category_id=?3",nativeQuery = true)
	public Integer findById123(Integer id1,Integer id2,Integer id3);

}
