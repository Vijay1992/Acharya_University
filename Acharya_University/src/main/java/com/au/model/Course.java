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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;

	@Column(nullable = false)
 	private String course_name;
	@Column(nullable = false)
	private String course_code;
	
	@NotNull
	private Integer course_type_id;// FK

	@Column(name = "created_Date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;

	@NotNull
	private Integer course_category_id;// FK
	@NotNull
	private Integer total_credit;
	@NotNull
	private Integer lecture;
	@NotNull
	private Integer tutorial;
	@NotNull
	private Integer practical;
	@NotNull
	private Integer duration;
	@NotNull
	private Integer dept_id; // FK
	@NotNull
	private Integer cie_marks;
	@NotNull
	private Integer see_marks;
	
	
	public Course() {
		super();
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public String getCourse_code() {
		return course_code;
	}


	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}


	public Integer getCourse_type_id() {
		return course_type_id;
	}


	public void setCourse_type_id(Integer course_type_id) {
		this.course_type_id = course_type_id;
	}


	public Date getCreated_Date() {
		return created_Date;
	}


	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}


	public Date getModified_Date() {
		return modified_Date;
	}


	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}


	public Integer getCourse_category_id() {
		return course_category_id;
	}


	public void setCourse_category_id(Integer course_category_id) {
		this.course_category_id = course_category_id;
	}


	public Integer getTotal_credit() {
		return total_credit;
	}


	public void setTotal_credit(Integer total_credit) {
		this.total_credit = total_credit;
	}


	public Integer getLecture() {
		return lecture;
	}


	public void setLecture(Integer lecture) {
		this.lecture = lecture;
	}


	public Integer getTutorial() {
		return tutorial;
	}


	public void setTutorial(Integer tutorial) {
		this.tutorial = tutorial;
	}


	public Integer getPractical() {
		return practical;
	}


	public void setPractical(Integer practical) {
		this.practical = practical;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Integer getDept_id() {
		return dept_id;
	}


	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}


	public Integer getCie_marks() {
		return cie_marks;
	}


	public void setCie_marks(Integer cie_marks) {
		this.cie_marks = cie_marks;
	}


	public Integer getSee_marks() {
		return see_marks;
	}


	public void setSee_marks(Integer see_marks) {
		this.see_marks = see_marks;
	}


}


/*
  {
	  "course_id": 3,
	  "course_name": "Engineering Maths I",
	  "course_code":"MAL101",
	  "course_type_id": 2,
	  "course_category_id": 3,
	  "total_credit": 5, 
	  "lecture": 3,
	  "tutorial": 1,
	  "practical": 0, 
	  "duration": 3, 
	  "dept_id": 1, 
	  "cie_marks": 40,
	  "see_marks": 60 
}
  
*/ 