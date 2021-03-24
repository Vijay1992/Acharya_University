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

	@Query(value = "select count(*) from tbl_au_fee_template where ac_year_id = ?1 and program_id=?2 and fee_admission_category_id=?3", nativeQuery = true)
	public Integer findById123(Integer id1, Integer id2, Integer id3);

	@Query(value = "SELECT fee_template_id,fee_template_name,school_name,ac_year,program_short_name,\r\n"
			+ "	currency_type_name,fee_admission_category_type,\r\n" + "	fee_admission_sub_category_short_name,\r\n"
			+ "	program_specialization_short_name,nationality\r\n"
			+ "	FROM  tbl_au_fee_template ft left join tbl_au_schools sh on ft.school_id= sh.school_id\r\n"
			+ " left outer join tbl_au_academic_year ay on ft.ac_year_id=ay.ac_year_id\r\n"
			+ " left outer join tbl_au_program ap on ft.program_id = ap.program_id\r\n"
			+ " left outer join  tbl_au_currency_type ct on ft.currency_id=ct.currency_id\r\n"
			+ " left outer join tbl_au_fee_admisison_category fad on ft.fee_admission_category_id= fad.fee_admission_category_id\r\n"
			+ " left outer join tbl_au_fee_admission_sub_category fasub on \r\n"
			+ "  ft.fee_admission_sub_category_id = fasub.fee_admission_sub_category_id\r\n"
			+ "left outer join tbl_au_program_specialization ps on \r\n"
			+ " ft.program_specialization_id = ps.program_specialization_id where ft.fee_template_id IN (:fee_template)", nativeQuery = true)
	public List<String> findByTemplateDetails(@Param("fee_template") List<String> fee_template_id);

	
	@Query(value = "select new map (ft.fee_template_id as fee_template_id,"
			+ "ft.fee_template_name as fee_template_name,"
			+ "sc.school_name_short as school_name_short,"
			+ "ac.ac_year as ac_year,"
			+ "ft.nationality as Nationality,"
			+ "p.program_short_name as program_short_name ,"
			+ "ft.active as Active,"
			+ "c.currency_type_name as currency_type_name ,"
			+ "fa.fee_admission_category_type as fee_admission_category_type,"
			+ "fas.fee_admission_sub_category_short_name as fee_admission_sub_category_short_name,"
			+ "ps.program_specialization_short_name as program_specialization_short_name)"
			+ "from FeeTemplate ft "
			+ "left join Schools sc on ft.school_id=sc.school_id "
			+ "left join Academic_year ac on ft.ac_year_id = ft.ac_year_id "
			+ "left join Program p on p.program_id = ft.program_id  "
			+ "left join Currency_Type c on c.currency_id = ft.currency_id  "
			+ "left join FeeAdmissionCategory fa on fa.fee_admission_category_id = ft.fee_admission_category_id  "
			+ "left join FeeAdmissionSubCategory fas on fas.fee_admission_sub_category_id = ft.fee_admission_sub_category_id  "
			+ "left join ProgramSpecilization ps on ps.program_specialization_id = ft.program_specialization_id where ft.fee_template_id IN (:fee_template)")
	public List<HashMap<String, Object>> fetchFeeTemplateDetails(@Param("fee_template") List<Integer> fee_template_id);

	
	
	/*
	 * 
	 * @Query(value =
	 * "select new map (ft.fee_template_id as fee_template_id,ft.fee_template_name as fee_template_name,sc.school_name_short as school_name_short)"
	 * +
	 * "from FeeTemplate ft left join Schools sc on ft.school_id=sc.school_id where ft.fee_template_id IN (:fee_template)"
	 * ) List<
	 * HashMap<String,Object>>fetchFeeTemplateDetails(@Param("fee_template")List<
	 * Integer> fee_template_id);
	 * 
	 */
 

	/*
	 * 
	 * 
	 * @Query(value =
	 * "SELECT fee_template_name,school_name_short,ac_year,program_short_name,\r\n"
	 * + "	currency_type_name,fee_admission_category_type,\r\n" +
	 * "	fee_admission_sub_category_short_name,\r\n" +
	 * "	program_specialization_short_name,nationality\r\n" +
	 * "	FROM  tbl_au_fee_template ft left join tbl_au_schools sh on ft.school_id= sh.school_id\r\n"
	 * +
	 * " left outer join tbl_au_academic_year ay on ft.ac_year_id=ay.ac_year_id\r\n"
	 * + " left outer join tbl_au_program ap on ft.program_id = ap.program_id\r\n" +
	 * " left outer join  tbl_au_currency_type ct on ft.currency_id=ct.currency_id\r\n"
	 * +
	 * " left outer join tbl_au_fee_admisison_category fad on ft.fee_admission_category_id= fad.fee_admission_category_id\r\n"
	 * + " left outer join tbl_au_fee_admission_sub_category fasub on \r\n" +
	 * "  ft.fee_admission_sub_category_id = fasub.fee_admission_sub_category_id\r\n"
	 * + "left outer join tbl_au_program_specialization ps on \r\n" +
	 * " ft.program_specialization_id = ps.program_specialization_id where ft.fee_template_id=?1"
	 * ,nativeQuery = true) public List<FeeTemplate> findByTemplateDetails(Integer
	 * id1);
	 * 
	 */
}
