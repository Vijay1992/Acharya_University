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
@Table(name = "tbl_au_education_details")
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edu_id;
	private Integer job_id;
	private Integer graduation_id;
	private String graduation_name;
	private String school_name;
	private String university_name;
	private Float academic_score;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date academic_year_joining;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date academic_year_completed;

	public EducationDetails() {
		super();
	}

	public Integer getEdu_id() {
		return edu_id;
	}

	public void setEdu_id(Integer edu_id) {
		this.edu_id = edu_id;
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public Integer getGraduation_id() {
		return graduation_id;
	}

	public void setGraduation_id(Integer graduation_id) {
		this.graduation_id = graduation_id;
	}

	public String getGraduation_name() {
		return graduation_name;
	}

	public void setGraduation_name(String graduation_name) {
		this.graduation_name = graduation_name;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public Float getAcademic_score() {
		return academic_score;
	}

	public void setAcademic_score(Float academic_score) {
		this.academic_score = academic_score;
	}

	public Date getAcademic_year_joining() {
		return academic_year_joining;
	}

	public void setAcademic_year_joining(Date academic_year_joining) {
		this.academic_year_joining = academic_year_joining;
	}

	public Date getAcademic_year_completed() {
		return academic_year_completed;
	}

	public void setAcademic_year_completed(Date academic_year_completed) {
		this.academic_year_completed = academic_year_completed;
	}

}
