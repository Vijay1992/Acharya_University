package com.au.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.au.model.FeeTemplate;

@Repository
public interface FeeTemplateRepository extends JpaRepository<FeeTemplate, Integer> {

	@Query(value = "select count(*) from tbl_au_fee_template where ac_year_id=?1 and fee_admission_category_id=?2 and program_id=?3", nativeQuery = true)
	public Integer findById(Integer id1, Integer id2, Integer id3);

	@Query(value = "select new map (ft.fee_template_id as fee_template_id,ft.fee_template_name as fee_template_name,"
			+ "sc.school_name_short as school_name_short,ac.ac_year as ac_year,ft.nationality as nationality,"
			+ "pr.program_short_name as program_short_name,ct.currency_type_name as currency_type_name,ft.active as active,"
			+ "fau.fee_admission_category_type as fee_admission_category_type,"
			+ "fasc.fee_admission_sub_category_name as fee_admission_sub_category_name,pt.program_type_name as program_type_name,"
			+ "pss.program_specialization_short_name as program_specialization_short_name)"
			+ "from FeeTemplate ft left join Schools sc on ft.school_id=sc.school_id "
			+ "left join AcademicYear ac on ft.ac_year_id=ac.ac_year_id "
			+ "left join Program pr on ft.program_id=pr.program_id "
			+ "left join CurrencyType ct on ft.currency_type_id= ct.currency_type_id "
			+ "left join FeeAdmissionCategory fau on ft.fee_admission_ca" + "tegory_id=fau.fee_admission_category_id "
			+ "left join FeeAdmissionSubCategory fasc on ft.fee_admission_sub_category_id= fasc.fee_admission_sub_category_id "
			+ "left join ProgramType pt on ft.program_type_id=pt.program_type_id "
			+ "left join ProgramSpecialization pss on ft.program_specialization_id=pss.program_specialization_id "
			+ "where ft.fee_template_id IN (:fee_template)")
	public List<HashMap<String, Object>> fetchFeeTemplateDetails(@Param("fee_template") List<Integer> fee_template_id);

	// @Query(value="SELECT
	// fasc.fee_admission_sub_category_id,fasc.fee_admission_sub_category_name FROM
	// tbl_au_fee_template as ft\r\n"
	// + "left join tbl_au_fee_admission_sub_category as fasc on
	// ft.fee_admission_sub_category_id=fasc.fee_admission_sub_category_id\r\n"
	// + "where ft.fee_admission_sub_category_id=?1", nativeQuery = true)

	@Query(value = "select new map(fasc.fee_admission_sub_category_id as fee_admission_sub_category_id,"
			+ "fasc.fee_admission_sub_category_name as fee_admission_sub_category_name) "
			+ "from FeeTemplate ft left join FeeAdmissionSubCategory fasc "
			+ "on ft.fee_admission_sub_category_id=fasc.fee_admission_sub_category_id where ft.fee_admission_sub_category_id=?1")
	public List<HashMap<String, Object>> fetchFeeTemplateDetail(Integer fee_admission_sub_category_id);

	/*
	 * Query(value =
	 * "select new map (ft.fee_template_id as fee_template_id,ft.fee_template_name as fee_template_name,"
	 * +
	 * "ft.ac_year_id as ac_year_id,ft.school_id as school_id,ft.program_id as program_id,"
	 * +
	 * "ft.program_specialization_id as program_specialization_id,ft.currency_type_id as currency_type_id,"
	 * + "ft.fee_admission_category_id as fee_admission_category_id," +
	 * "ft.fee_admission_sub_category_id as fee_admission_sub_category_id,ft.Is_nri as is_nri,"
	 * +
	 * "ft.Is_paid_at_board as is_paid_at_board,ft.nationality as nationality,ft.program_type_id as program_type_id,"
	 * +
	 * "ft.created_date as created_date,ft.modified_date as modified_date,ft.active as active,"
	 * +
	 * "ft.remarks as remarks,ft.created_by as created_by,ft.modified_by as modified_by,ft.approved_by as approved_by,"
	 * + "ft.approved_status as approved_status,ft.approved_date as approved_date,"
	 * + "fasc.fee_admission_sub_category_name as fee_admission_sub_category_name) "
	 * + "from FeeTemplate as ft left join FeeAdmissionSubCategory as fasc " +
	 * "on ft.fee_admission_sub_category_id=fasc.fee_admission_sub_category_id ")
	 * public List<HashMap<String, Object>> findAll1();
	 */

	@Query(value = "select f from FeeTemplate f where fee_template_id=?1")
	public FeeTemplate findByfee_template_id(Integer fee_template_id);

}
