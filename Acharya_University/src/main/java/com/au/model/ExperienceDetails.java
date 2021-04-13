package com.au.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_au_experience_details")
public class ExperienceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer exp_id;
	private Integer job_id;
	private String employer_name;
	private String designation;
	private String job_profile;
	private String skills;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date exp_doj;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date exp_dol;
	private Integer exp_in_years;
	private Integer exp_in_months;

	public ExperienceDetails() {
		super();
	}

	public Integer getExp_id() {
		return exp_id;
	}

	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJob_profile() {
		return job_profile;
	}

	public void setJob_profile(String job_profile) {
		this.job_profile = job_profile;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Date getExp_doj() {
		return exp_doj;
	}

	public void setExp_doj(Date exp_doj) {
		this.exp_doj = exp_doj;
	}

	public Date getExp_dol() {
		return exp_dol;
	}

	public void setExp_dol(Date exp_dol) {
		this.exp_dol = exp_dol;
	}

	public Integer getExp_in_years() {
		return exp_in_years;
	}

	public void setExp_in_years(Integer exp_in_years) {
		this.exp_in_years = exp_in_years;
	}

	public Integer getExp_in_months() {
		return exp_in_months;
	}

	public void setExp_in_months(Integer exp_in_months) {
		this.exp_in_months = exp_in_months;
	}

}
