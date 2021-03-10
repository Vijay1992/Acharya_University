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
@Table(name = "tbl_au_academic_program")
public class AcademicProgram 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer academic_program_id;
	
	private Integer ac_year_id; //FK
	private Integer program_id; //FK
	
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp	
	private Date modified_date;
	
	private Integer number_of_years; 
	private Integer number_of_semester;
	private boolean active;
	
	public AcademicProgram() {
		super();
	}
	
	
	public AcademicProgram(Integer ac_year_id, Integer program_id, Date created_date, Date modified_date,
			Integer number_of_years, Integer number_of_semester, boolean active) {
		super();
		this.ac_year_id = ac_year_id;
		this.program_id = program_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.number_of_years = number_of_years;
		this.number_of_semester = number_of_semester;
		this.active = active;
	}


	public AcademicProgram(Integer academic_program_id, Integer ac_year_id, Integer program_id, Date created_date,
			Date modified_date, Integer number_of_years, Integer number_of_semester, boolean active) {
		super();
		this.academic_program_id = academic_program_id;
		this.ac_year_id = ac_year_id;
		this.program_id = program_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.number_of_years = number_of_years;
		this.number_of_semester = number_of_semester;
		this.active = active;
	}
	public Integer getAcademic_program_id() {
		return academic_program_id;
	}
	public void setAcademic_program_id(Integer academic_program_id) {
		this.academic_program_id = academic_program_id;
	}
	public Integer getAc_year_id() {
		return ac_year_id;
	}
	public void setAc_year_id(Integer ac_year_id) {
		this.ac_year_id = ac_year_id;
	}
	public Integer getProgram_id() {
		return program_id;
	}
	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
