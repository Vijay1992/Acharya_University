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
@Table(name = "tbl_au_program_type")
public class ProgramType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer program_type_id;
	private String program_type_name;
	private String program_type_code;
	private Integer created_by;
	private Integer modified_by;
	private Boolean active;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;

	public Integer getProgram_type_id() {
		return program_type_id;
	}

	public void setProgram_type_id(Integer program_type_id) {
		this.program_type_id = program_type_id;
	}

	public String getProgram_type_name() {
		return program_type_name;
	}

	public void setProgram_type_name(String program_type_name) {
		this.program_type_name = program_type_name;
	}

	public String getProgram_type_code() {
		return program_type_code;
	}

	public void setProgram_type_code(String program_type_code) {
		this.program_type_code = program_type_code;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	

}
