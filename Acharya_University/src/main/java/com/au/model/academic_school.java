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
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_au_academic_school")
public class academic_school {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer academic_school_id;
	private Integer ac_year_id;
	private Integer school_id;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "from_date")
	private Date from_date;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "to_date")
	private Date to_date;
	
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	private Integer created_by;
	private Integer modified_by;
	private boolean active;
	public academic_school() {
		super();
	}
	
	
	public Integer getAcademic_school_id() {
		return academic_school_id;
	}
	public void setAcademic_school_id(Integer academic_school_id) {
		this.academic_school_id = academic_school_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	
	

	public Integer getAc_year_id() {
		return ac_year_id;
	}


	public void setAc_year_id(Integer ac_year_id) {
		this.ac_year_id = ac_year_id;
	}


	public Date getFrom_date() {
		return from_date;
	}


	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}


	public Date getTo_date() {
		return to_date;
	}


	public void setTo_date(Date to_date) {
		this.to_date = to_date;
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
	
}
