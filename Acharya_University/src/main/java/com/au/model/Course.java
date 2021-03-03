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
@Table(name = "tbl_au_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer course_id;
	private String course_name;
	private String course_code;
	private Integer course_type_id; // FK

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;
	private String course_short_name;
	private Integer course_category_id; // FK
	private Integer total_credit;
	private Integer lecture;
	private Integer tutorial;
	private Integer practical;
	private Integer duration;
	private Integer dept_id; // FK
	private Integer cie_marks;
	private Integer see_marks;
	private Integer number_of_years;
	private Integer number_of_semester;
	private Integer created_by;
	private Integer modified_by;
	private boolean active;
	private String ref_details;
	private String hod_email;
	private Integer school_id;

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
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

	public String getCourse_short_name() {
		return course_short_name;
	}

	public void setCourse_short_name(String course_short_name) {
		this.course_short_name = course_short_name;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRef_details() {
		return ref_details;
	}

	public void setRef_details(String ref_details) {
		this.ref_details = ref_details;
	}

	public String getHod_email() {
		return hod_email;
	}

	public void setHod_email(String hod_email) {
		this.hod_email = hod_email;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

}

/*
 * { "course_id": 3, "course_name": "Engineering Maths I",
 * "course_code":"MAL101", "course_type_id": 2, "course_category_id": 3,
 * "total_credit": 5, "lecture": 3, "tutorial": 1, "practical": 0, "duration":
 * 3, "dept_id": 1, "cie_marks": 40, "see_marks": 60 }
 * 
 */