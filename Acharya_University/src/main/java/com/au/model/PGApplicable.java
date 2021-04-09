package com.au.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_pg_applicable")
public class PGApplicable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 	private String Pg_Exam_passed_name;
 	private String University;
 	private String Year_of_Passing;
 	private Integer Std_id;
	private String Subject_studied_lang;
	private Integer Year_1;
	private Integer Year_2;
	private Integer Year_3;
	private Integer Year_4;
	private float Pg_total_percentage;
	private Integer created_by;
	private Integer modified_by;
	
	@Column(name = "created_Date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;
	
	private String remarks;
	private String auid;
	private Integer candidateID;
	
	public PGApplicable() {
		super();
	}

	public PGApplicable(Integer id, String pg_Exam_passed_name, String university, String year_of_Passing,
			Integer std_id, String subject_studied_lang, Integer year_1, Integer year_2, Integer year_3, Integer year_4,
			float pg_total_percentage, Integer created_by, Integer modified_by, Date created_Date, Date modified_Date,
			String remarks, String auid, Integer candidateID) {
		super();
		this.id = id;
		Pg_Exam_passed_name = pg_Exam_passed_name;
		University = university;
		Year_of_Passing = year_of_Passing;
		Std_id = std_id;
		Subject_studied_lang = subject_studied_lang;
		Year_1 = year_1;
		Year_2 = year_2;
		Year_3 = year_3;
		Year_4 = year_4;
		Pg_total_percentage = pg_total_percentage;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
		this.remarks = remarks;
		this.auid = auid;
		this.candidateID = candidateID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPg_Exam_passed_name() {
		return Pg_Exam_passed_name;
	}

	public void setPg_Exam_passed_name(String pg_Exam_passed_name) {
		Pg_Exam_passed_name = pg_Exam_passed_name;
	}

	public String getUniversity() {
		return University;
	}

	public void setUniversity(String university) {
		University = university;
	}

	public String getYear_of_Passing() {
		return Year_of_Passing;
	}

	public void setYear_of_Passing(String year_of_Passing) {
		Year_of_Passing = year_of_Passing;
	}

	public Integer getStd_id() {
		return Std_id;
	}

	public void setStd_id(Integer std_id) {
		Std_id = std_id;
	}

	public String getSubject_studied_lang() {
		return Subject_studied_lang;
	}

	public void setSubject_studied_lang(String subject_studied_lang) {
		Subject_studied_lang = subject_studied_lang;
	}

	public Integer getYear_1() {
		return Year_1;
	}

	public void setYear_1(Integer year_1) {
		Year_1 = year_1;
	}

	public Integer getYear_2() {
		return Year_2;
	}

	public void setYear_2(Integer year_2) {
		Year_2 = year_2;
	}

	public Integer getYear_3() {
		return Year_3;
	}

	public void setYear_3(Integer year_3) {
		Year_3 = year_3;
	}

	public Integer getYear_4() {
		return Year_4;
	}

	public void setYear_4(Integer year_4) {
		Year_4 = year_4;
	}

	public float getPg_total_percentage() {
		return Pg_total_percentage;
	}

	public void setPg_total_percentage(float pg_total_percentage) {
		Pg_total_percentage = pg_total_percentage;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public Integer getModified_by() {
		return modified_by;
	}

	public void setModified_by(Integer modified_by) {
		this.modified_by = modified_by;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Date getModified_Date() {
		return modified_Date;
	}

	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAuid() {
		return auid;
	}

	public void setAuid(String auid) {
		this.auid = auid;
	}

	public Integer getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(Integer candidateID) {
		this.candidateID = candidateID;
	}

	
	
}
