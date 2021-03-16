package com.au.model;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class FeeTemplateRequest {

	private String fee_template_name;
	private Integer ac_year_id;
	private String ac_year; // na
	private Integer school_id; // Fk
	private Integer program_id; // Fk
	private String program_sht; // na
	private String Program_Specialization_id;
	private Integer currency_id;
	private String currency_short; // na
	private Integer fee_admission_category_id;
	private String fee_admission_category;  //na
	private HashMap<Integer, String> fee_admission_sub_category_id;
	private boolean Is_paid_at_board;    //na
	private String nationality_id;
	private boolean Is_NRI;               //na
	private Integer program_type_id;
	private Integer approved_by;              //na
	private boolean approved_status;           //na
	private Date approved_date;
	private Integer created_by;
	private Integer modified_by;
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;
	private boolean active;      //na
	private String remarks;

	public FeeTemplateRequest() {
		super();
	}

	public FeeTemplateRequest(String fee_template_name, Integer ac_year_id, String ac_year, Integer school_id,
			Integer program_id, String program_sht, String program_Specialization_id, Integer currency_id,
			String currency_short, Integer fee_admission_category_id, String fee_admission_category,
			HashMap<Integer, String> fee_admission_sub_category_id, boolean is_paid_at_board, String nationality_id,
			boolean is_NRI, Integer program_type_id, Integer approved_by, boolean approved_status, Date approved_date,
			Integer created_by, Integer modified_by, Date created_date, Date modified_date, boolean active,
			String remarks) {
		super();
		this.fee_template_name = fee_template_name;
		this.ac_year_id = ac_year_id;
		this.ac_year = ac_year;
		this.school_id = school_id;
		this.program_id = program_id;
		this.program_sht = program_sht;
		Program_Specialization_id = program_Specialization_id;
		this.currency_id = currency_id;
		this.currency_short = currency_short;
		this.fee_admission_category_id = fee_admission_category_id;
		this.fee_admission_category = fee_admission_category;
		this.fee_admission_sub_category_id = fee_admission_sub_category_id;
		Is_paid_at_board = is_paid_at_board;
		this.nationality_id = nationality_id;
		Is_NRI = is_NRI;
		this.program_type_id = program_type_id;
		this.approved_by = approved_by;
		this.approved_status = approved_status;
		this.approved_date = approved_date;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
		this.remarks = remarks;
	}

	public String getFee_template_name() {
		return fee_template_name;
	}

	public void setFee_template_name(String fee_template_name) {
		this.fee_template_name = fee_template_name;
	}

	public Integer getAc_year_id() {
		return ac_year_id;
	}

	public void setAc_year_id(Integer ac_year_id) {
		this.ac_year_id = ac_year_id;
	}

	public String getAc_year() {
		return ac_year;
	}

	public void setAc_year(String ac_year) {
		this.ac_year = ac_year;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getProgram_id() {
		return program_id;
	}

	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
	}

	public String getProgram_sht() {
		return program_sht;
	}

	public void setProgram_sht(String program_sht) {
		this.program_sht = program_sht;
	}

	public String getProgram_Specialization_id() {
		return Program_Specialization_id;
	}

	public void setProgram_Specialization_id(String program_Specialization_id) {
		Program_Specialization_id = program_Specialization_id;
	}

	public Integer getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(Integer currency_id) {
		this.currency_id = currency_id;
	}

	public String getCurrency_short() {
		return currency_short;
	}

	public void setCurrency_short(String currency_short) {
		this.currency_short = currency_short;
	}

	public Integer getFee_admission_category_id() {
		return fee_admission_category_id;
	}

	public void setFee_admission_category_id(Integer fee_admission_category_id) {
		this.fee_admission_category_id = fee_admission_category_id;
	}

	public String getFee_admission_category() {
		return fee_admission_category;
	}

	public void setFee_admission_category(String fee_admission_category) {
		this.fee_admission_category = fee_admission_category;
	}

	public HashMap<Integer, String> getFee_admission_sub_category_id() {
		return fee_admission_sub_category_id;
	}

	public void setFee_admission_sub_category_id(HashMap<Integer, String> fee_admission_sub_category_id) {
		this.fee_admission_sub_category_id = fee_admission_sub_category_id;
	}

	public boolean isIs_paid_at_board() {
		return Is_paid_at_board;
	}

	public void setIs_paid_at_board(boolean is_paid_at_board) {
		Is_paid_at_board = is_paid_at_board;
	}

	public String getNationality_id() {
		return nationality_id;
	}

	public void setNationality_id(String nationality_id) {
		this.nationality_id = nationality_id;
	}

	public boolean isIs_NRI() {
		return Is_NRI;
	}

	public void setIs_NRI(boolean is_NRI) {
		Is_NRI = is_NRI;
	}

	public Integer getProgram_type_id() {
		return program_type_id;
	}

	public void setProgram_type_id(Integer program_type_id) {
		this.program_type_id = program_type_id;
	}

	public Integer getApproved_by() {
		return approved_by;
	}

	public void setApproved_by(Integer approved_by) {
		this.approved_by = approved_by;
	}

	public boolean isApproved_status() {
		return approved_status;
	}

	public void setApproved_status(boolean approved_status) {
		this.approved_status = approved_status;
	}

	public Date getApproved_date() {
		return approved_date;
	}

	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
