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
@Table(name = "tbl_au_program")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer program_id;

	private String program_name;
	private Integer program_type_id;//fk
	private String program_short_name;
	
	private Integer school_id;//fk
	private Integer created_by;
	private Integer modified_by;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;
	private Boolean active;
	
	private Integer graduation_id;//FK
	
	private Integer number_of_years;
	private Integer number_of_semester;
	public Program() {
		super();
	}
	public Program(Integer program_id, String program_name, Integer program_type_id, String program_short_name,
			Integer school_id, Integer created_by, Integer modified_by, Date created_date, Date modified_date,
			Boolean active, Integer graduation_id, Integer number_of_years, Integer number_of_semester) {
		super();
		this.program_id = program_id;
		this.program_name = program_name;
		this.program_type_id = program_type_id;
		this.program_short_name = program_short_name;
		this.school_id = school_id;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
		this.graduation_id = graduation_id;
		this.number_of_years = number_of_years;
		this.number_of_semester = number_of_semester;
	}
	public Integer getProgram_id() {
		return program_id;
	}
	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public Integer getProgram_type_id() {
		return program_type_id;
	}
	public void setProgram_type_id(Integer program_type_id) {
		this.program_type_id = program_type_id;
	}
	public String getProgram_short_name() {
		return program_short_name;
	}
	public void setProgram_short_name(String program_short_name) {
		this.program_short_name = program_short_name;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Integer getGraduation_id() {
		return graduation_id;
	}
	public void setGraduation_id(Integer graduation_id) {
		this.graduation_id = graduation_id;
	}
	public Integer getNumber_of_years() {
		return number_of_years;
	}
	public void setNumber_of_years(Integer number_of_years) {
		this.number_of_years = number_of_years;
	}
	public Integer getNumber_of_semester() {
		return number_of_semester;
	}
	public void setNumber_of_semester(Integer number_of_semester) {
		this.number_of_semester = number_of_semester;
	}
	
	
	
	
	
}
