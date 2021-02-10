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
@Table(name = "tbl_au_program")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int program_id;
	
	@Column(name = "program_name")
	@NotBlank
	private String program_name;
	
	@Column(name = "program_code")
	@NotBlank
	private String program_code;

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;

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

	/**
	 * @return the program_name
	 */
	public String getProgram_name() {
		return program_name;
	}

	/**
	 * @param program_name the program_name to set
	 */
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	/**
	 * @return the program_code
	 */
	public String getProgram_code() {
		return program_code;
	}

	/**
	 * @param program_code the program_code to set
	 */
	public void setProgram_code(String program_code) {
		this.program_code = program_code;
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
