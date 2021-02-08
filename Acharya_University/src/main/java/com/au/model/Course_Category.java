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

import com.sun.istack.NotNull;

@Entity
@Table(name = "tbl_au_course_category")
public class Course_Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_category_id;

	@NotBlank
	private String course_category_name;
	private String course_category_code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date",updatable = false)
	@CreationTimestamp
	private Date created_date;
	
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;


	public int getCourse_category_id() {
		return course_category_id;
	}

	public void setCourse_category_id(int course_category_id) {
		this.course_category_id = course_category_id;
	}

	public String getCourse_category_name() {
		return course_category_name;
	}

	public void setCourse_category_name(String course_category_name) {
		this.course_category_name = course_category_name;
	}

	public String getCourse_category_code() {
		return course_category_code;
	}

	public void setCourse_category_code(String course_category_code) {
		this.course_category_code = course_category_code;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public Date getCreated_date() {
		return created_date;
	}


}
