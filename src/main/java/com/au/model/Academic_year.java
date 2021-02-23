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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_academic_year")
public class Academic_year {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ac_year_id;	
	
	private String ac_year;
	private String ac_year_code;
	
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
	private Integer current_year;
	
	public Academic_year() {
		super();
	}

	public Academic_year(Integer ac_year_id, String ac_year, String ac_year_code, Date created_date, Date modified_date,
			Integer created_by, Integer modified_by, boolean active, Integer current_year) {
		super();
		this.ac_year_id = ac_year_id;
		this.ac_year = ac_year;
		this.ac_year_code = ac_year_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.active = active;
		this.current_year = current_year;
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

	public String getAc_year_code() {
		return ac_year_code;
	}

	public void setAc_year_code(String ac_year_code) {
		this.ac_year_code = ac_year_code;
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

	public Integer getCurrent_year() {
		return current_year;
	}

	public void setCurrent_year(Integer current_year) {
		this.current_year = current_year;
	}

}