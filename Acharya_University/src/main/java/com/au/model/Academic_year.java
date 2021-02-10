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
	@Column(name = "year_id")
	private int year_id;	
	
	@NotBlank
	private String academic_year;
	@NotBlank
	private String academic_year_code;
	
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;

	/**
	 * 
	 */
	public Academic_year() {
		super();
	}

	/**
	 * @param academic_year
	 * @param academic_year_code
	 * @param created_date
	 * @param modified_date
	 */
	public Academic_year(String academic_year, String academic_year_code, Date created_date, Date modified_date) {
		this.academic_year = academic_year;
		this.academic_year_code = academic_year_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	/**
	 * @param year_id
	 * @param academic_year
	 * @param academic_year_code
	 * @param created_date
	 * @param modified_date
	 */
	public Academic_year(int year_id, String academic_year, String academic_year_code, Date created_date,
			Date modified_date) {
		this.year_id = year_id;
		this.academic_year = academic_year;
		this.academic_year_code = academic_year_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	/**
	 * @return the year_id
	 */
	public int getYear_id() {
		return year_id;
	}

	/**
	 * @param year_id the year_id to set
	 */
	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}

	/**
	 * @return the academic_year
	 */
	public String getAcademic_year() {
		return academic_year;
	}

	/**
	 * @param academic_year the academic_year to set
	 */
	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
	}

	/**
	 * @return the academic_year_code
	 */
	public String getAcademic_year_code() {
		return academic_year_code;
	}

	/**
	 * @param academic_year_code the academic_year_code to set
	 */
	public void setAcademic_year_code(String academic_year_code) {
		this.academic_year_code = academic_year_code;
	}

	/**
	 * @return the created_date
	 */
	public Date getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	/**
	 * @return the modified_date
	 */
	public Date getModified_date() {
		return modified_date;
	}

	/**
	 * @param modified_date the modified_date to set
	 */
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "Academic_year [year_id=" + year_id + ", academic_year=" + academic_year + ", academic_year_code="
				+ academic_year_code + ", created_date=" + created_date + ", modified_date=" + modified_date + "]";
	}

	
	
	
}
