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
	Integer findById123(Integer id1, Integer id2, Integer id3);

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
			+ "left join FeeAdmissionCategory fau on ft.fee_admission_category_id=fau.fee_admission_category_id "
			+ "left join FeeAdmissionSubCategory fasc on ft.fee_admission_sub_category_id= fasc.fee_admission_sub_category_id "
			+ "left join ProgramType pt on ft.program_type_id=pt.program_type_id "
			+ "left join ProgramSpecialization pss on ft.program_specialization_id=pss.program_specialization_id "
			+ "where ft.fee_template_id IN (:fee_template)")
	List<HashMap<String, Object>> fetchFeeTemplateDetails(@Param("fee_template") List<Integer> fee_template_id);

}
