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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_schools")
public class Schools {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer school_id;	
	private String school_name;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date created_date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date;
	private Integer org_id;

	private String school_name_short;
	private String school_desc;
	private Integer created_by;
	private Integer modified_by;
	private boolean active;
	private boolean week_off;
	private String job_type;
	private String ref_no;
	private String email_id;	
	private String mobile_no;
	private String school_color;
	private Integer creditap_production_id;

	public Schools() {
		super();
	}


	public Schools(Integer school_id, String school_name, Date created_date, Date modified_date, Integer org_id,
			String school_name_short, String school_desc, Integer created_by, Integer modified_by, boolean active,
			boolean week_off, String job_type, String ref_no, String email_id, String mobile_no, String school_color,
			Integer creditap_production_id) {
		super();
		this.school_id = school_id;
		this.school_name = school_name;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.org_id = org_id;
		this.school_name_short = school_name_short;
		this.school_desc = school_desc;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.active = active;
		this.week_off = week_off;
		this.job_type = job_type;
		this.ref_no = ref_no;
		this.email_id = email_id;
		this.mobile_no = mobile_no;
		this.school_color = school_color;
		this.creditap_production_id = creditap_production_id;
	}


	public Integer getSchool_id() {
		return school_id;
	}


	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}


	public String getSchool_name() {
		return school_name;
	}


	public void setSchool_name(String school_name) {
		this.school_name = school_name;
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


	public Integer getOrg_id() {
		return org_id;
	}


	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}


	public String getSchool_name_short() {
		return school_name_short;
	}


	public void setSchool_name_short(String school_name_short) {
		this.school_name_short = school_name_short;
	}


	public String getSchool_desc() {
		return school_desc;
	}


	public void setSchool_desc(String school_desc) {
		this.school_desc = school_desc;
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


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isWeek_off() {
		return week_off;
	}


	public void setWeek_off(boolean week_off) {
		this.week_off = week_off;
	}


	public String getJob_type() {
		return job_type;
	}


	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}


	public String getRef_no() {
		return ref_no;
	}


	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getSchool_color() {
		return school_color;
	}


	public void setSchool_color(String school_color) {
		this.school_color = school_color;
	}


	public Integer getCreditap_production_id() {
		return creditap_production_id;
	}


	public void setCreditap_production_id(Integer creditap_production_id) {
		this.creditap_production_id = creditap_production_id;
	}

	
	
	
	
}
