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
@Table(name = "tbl_au_major_struc")
public class Major_struc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int major_id;
	
	@Column(name = "major_name",nullable = false)
	private String major_name;
	@Column(name = "dept_id",nullable = false)
	private int dept_id;  //FK

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;

	/**
	 * @return the major_id
	 */
	public int getMajor_id() {
		return major_id;
	}

	/**
	 * @param major_id the major_id to set
	 */
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	/**
	 * @return the major_name
	 */
	public String getMajor_name() {
		return major_name;
	}

	/**
	 * @param major_name the major_name to set
	 */
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}

	/**
	 * @return the dept_id
	 */
	public int getDept_id() {
		return dept_id;
	}

	/**
	 * @param dept_id the dept_id to set
	 */
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
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
	
	
	
}
