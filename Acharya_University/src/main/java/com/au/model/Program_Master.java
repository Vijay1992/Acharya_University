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
@Table(name = "tbl_au_program_master")
public class Program_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int master_id;
	
	@Column(nullable = false)
	private int max_duration_in_years;
	

	@Column(nullable = false)
	private int credits_completion_first_year;
	
	@Column(nullable = false)
	private int credits_completion_second_year;
	
	@Column(nullable = false)
	private int credits_completion_third_year;
	
	@Column(nullable = false)
	private int credits_completion_fourth_year;
	
	@Column(nullable = false)
	private int Total_Min_credits;
	
	@Column(nullable = false)
	private int Total_Max_credits;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date",updatable = false)
	@CreationTimestamp
	private Date created_date;
	
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;

	@Column(nullable = false)
	private int program_id; //FK
	
	@Column(nullable = false)
	private int school_id;  //FK
	
	@Column(nullable = false)
	private int major_id;   //FK
	
	@Column(nullable = false)
	private int dept_id;    //FK
	
	@Column(nullable = false)
	private int syllabus_id;//FK
	
	
	public Program_Master() {
		super();
	}

	public int getMaster_id() {
		return master_id;
	}

	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}

	public int getMax_duration_in_years() {
		return max_duration_in_years;
	}

	public void setMax_duration_in_years(int max_duration_in_years) {
		this.max_duration_in_years = max_duration_in_years;
	}

	public int getCredits_completion_first_year() {
		return credits_completion_first_year;
	}

	public void setCredits_completion_first_year(int credits_completion_first_year) {
		this.credits_completion_first_year = credits_completion_first_year;
	}

	public int getCredits_completion_second_year() {
		return credits_completion_second_year;
	}

	public void setCredits_completion_second_year(int credits_completion_second_year) {
		this.credits_completion_second_year = credits_completion_second_year;
	}

	public int getCredits_completion_third_year() {
		return credits_completion_third_year;
	}

	public void setCredits_completion_third_year(int credits_completion_third_year) {
		this.credits_completion_third_year = credits_completion_third_year;
	}

	public int getCredits_completion_fourth_year() {
		return credits_completion_fourth_year;
	}

	public void setCredits_completion_fourth_year(int credits_completion_fourth_year) {
		this.credits_completion_fourth_year = credits_completion_fourth_year;
	}

	public int getTotal_Min_credits() {
		return Total_Min_credits;
	}

	public void setTotal_Min_credits(int total_Min_credits) {
		Total_Min_credits = total_Min_credits;
	}

	public int getTotal_Max_credits() {
		return Total_Max_credits;
	}

	public void setTotal_Max_credits(int total_Max_credits) {
		Total_Max_credits = total_Max_credits;
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

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public int getSyllabus_id() {
		return syllabus_id;
	}

	public void setSyllabus_id(int syllabus_id) {
		this.syllabus_id = syllabus_id;
	}
	
	
}
