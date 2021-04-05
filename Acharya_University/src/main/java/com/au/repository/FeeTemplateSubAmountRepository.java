package com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.model.FeeTemplateSubAmount;

@Repository
public interface FeeTemplateSubAmountRepository extends JpaRepository<FeeTemplateSubAmount, Integer> {

	// @Query(value = "select f from FeeTemplate f where fee_template_id=?1")
	// @Query(value = "select new map(ftsa.fee_sub_amt_id as
	// fee_sub_amt_id,ftsa.fee_template_id as fee_template_id,ftsa.voucher_head_id
	// as voucher_head_id,ftsa.board_unique_id as board_unique_id,ftsa.alias_id as
	// alias_id,ftsa.year1_amt as year1_amt,ftsa.year2_amt as
	// year2_amt,ftsa.year3_amt as year3_amt,ftsa.year4_amt as
	// year4_amt,ftsa.year5_amt as year5_amt,ftsa.year6_amt as
	// year6_amt,ftsa.year7_amt as year7_amt,ftsa.year8_amt as
	// year8_amt,ftsa.year9_amt as year9_amt,ftsa.year10_amt as
	// year10_amt,ftsa.year11_amt as year2_amt,ftsa.year12_amt as
	// year12_amt,ftsa.total_amt as total_amt,ftsa.created_by as
	// created_by,ftsa.modified_by as modified_by,ftsa.receive_for_all_year as
	// receive_for_all_year,ftsa.active as active,ftsa.remarks as
	// remarks,ft.fee_year1_amt as fee_year1_amt,ft.fee_year2_amt as
	// fee_year2_amt,ft.fee_year3_amt as fee_year3_amt,ft.fee_year4_amt as
	// fee_year4_amt,ft.fee_year5_amt as fee_year5_amt,ft.fee_year6_amt as
	// fee_year6_amt,ft.fee_year7_amt as fee_year7_amt,ft.fee_year8_amt as
	// fee_year8_amt,ft.fee_year9_amt as fee_year9_amt,ft.fee_year10_amt as
	// fee_year10_amt,ft.fee_year11_amt as fee_year11_amt,ft.fee_year12_amt as
	// fee_year12_amt) from FeeTemplateSubAmount ftsa left join FeeTemplate ft on
	// ftsa.fee_template_id=ft.fee_template_id")
	// public FeeTemplateSubAmount save1(FeeTemplateSubAmount feetemplatesubamount);

}
