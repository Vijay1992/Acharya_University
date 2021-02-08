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
@Table(name = "tbl_au_syllabus")
public class Syllabus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int syllabus_id;
	
	@Column(nullable = false)
	private String syllabus;

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;

	
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;

	@Column(nullable = false)
	private int program_id;//FK

	/**
	 * @return the syllabus_id
	 */
	public int getSyllabus_id() {
		return syllabus_id;
	}


	/**
	 * @param syllabus_id the syllabus_id to set
	 */
	public void setSyllabus_id(int syllabus_id) {
		this.syllabus_id = syllabus_id;
	}


	/**
	 * @return the syllabus
	 */
	public String getSyllabus() {
		return syllabus;
	}


	/**
	 * @param syllabus the syllabus to set
	 */
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
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


	/**
	 * @return the program_id
	 */
	public int getProgram_id() {
		return program_id;
	}


	/**
	 * @param program_id the program_id to set
	 */
	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	
	
}
