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
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;

 	private String course_name;
	private String course_code;

	private int course_type_id;// FK

	@Column(name = "created_Date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;

	private int course_category_id;// FK

	private int total_credit;
	private int lecture;
	private int tutorial;
	private int practical;
	private int duration;

	private int dept_id; // FK

	private int cie_marks;
	private int see_marks;
	
	
	public Course() {
		super();
	}


	public Course(String course_name, String course_code, int course_type_id, Date created_Date, Date modified_Date,
			int course_category_id, int total_credit, int lecture, int tutorial, int practical, int duration,
			int dept_id, int cie_marks, int see_marks) {
		super();
		this.course_name = course_name;
		this.course_code = course_code;
		this.course_type_id = course_type_id;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
		this.course_category_id = course_category_id;
		this.total_credit = total_credit;
		this.lecture = lecture;
		this.tutorial = tutorial;
		this.practical = practical;
		this.duration = duration;
		this.dept_id = dept_id;
		this.cie_marks = cie_marks;
		this.see_marks = see_marks;
	}


	public Course(int course_id, String course_name, String course_code, int course_type_id, Date created_Date,
			Date modified_Date, int course_category_id, int total_credit, int lecture, int tutorial, int practical,
			int duration, int dept_id, int cie_marks, int see_marks) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_code = course_code;
		this.course_type_id = course_type_id;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
		this.course_category_id = course_category_id;
		this.total_credit = total_credit;
		this.lecture = lecture;
		this.tutorial = tutorial;
		this.practical = practical;
		this.duration = duration;
		this.dept_id = dept_id;
		this.cie_marks = cie_marks;
		this.see_marks = see_marks;
	}


	/**
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}


	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	/**
	 * @return the course_name
	 */
	public String getCourse_name() {
		return course_name;
	}


	/**
	 * @param course_name the course_name to set
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	/**
	 * @return the course_code
	 */
	public String getCourse_code() {
		return course_code;
	}


	/**
	 * @param course_code the course_code to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}


	/**
	 * @return the course_type_id
	 */
	public int getCourse_type_id() {
		return course_type_id;
	}


	/**
	 * @param course_type_id the course_type_id to set
	 */
	public void setCourse_type_id(int course_type_id) {
		this.course_type_id = course_type_id;
	}


	/**
	 * @return the created_Date
	 */
	public Date getCreated_Date() {
		return created_Date;
	}


	/**
	 * @param created_Date the created_Date to set
	 */
	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}


	/**
	 * @return the modified_Date
	 */
	public Date getModified_Date() {
		return modified_Date;
	}


	/**
	 * @param modified_Date the modified_Date to set
	 */
	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}


	/**
	 * @return the course_category_id
	 */
	public int getCourse_category_id() {
		return course_category_id;
	}


	/**
	 * @param course_category_id the course_category_id to set
	 */
	public void setCourse_category_id(int course_category_id) {
		this.course_category_id = course_category_id;
	}


	/**
	 * @return the total_credit
	 */
	public int getTotal_credit() {
		return total_credit;
	}


	/**
	 * @param total_credit the total_credit to set
	 */
	public void setTotal_credit(int total_credit) {
		this.total_credit = total_credit;
	}


	/**
	 * @return the lecture
	 */
	public int getLecture() {
		return lecture;
	}


	/**
	 * @param lecture the lecture to set
	 */
	public void setLecture(int lecture) {
		this.lecture = lecture;
	}


	/**
	 * @return the tutorial
	 */
	public int getTutorial() {
		return tutorial;
	}


	/**
	 * @param tutorial the tutorial to set
	 */
	public void setTutorial(int tutorial) {
		this.tutorial = tutorial;
	}


	/**
	 * @return the practical
	 */
	public int getPractical() {
		return practical;
	}


	/**
	 * @param practical the practical to set
	 */
	public void setPractical(int practical) {
		this.practical = practical;
	}


	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}


	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
	 * @return the cie_marks
	 */
	public int getCie_marks() {
		return cie_marks;
	}


	/**
	 * @param cie_marks the cie_marks to set
	 */
	public void setCie_marks(int cie_marks) {
		this.cie_marks = cie_marks;
	}


	/**
	 * @return the see_marks
	 */
	public int getSee_marks() {
		return see_marks;
	}


	/**
	 * @param see_marks the see_marks to set
	 */
	public void setSee_marks(int see_marks) {
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