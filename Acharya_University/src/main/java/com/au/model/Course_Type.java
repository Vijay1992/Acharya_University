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

@Entity
@Table(name = "tbl_au_course_type")
public class Course_Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_type_id;
	
	@NotBlank
	private String course_type_name;
	@NotBlank
	private String course_type_code;

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	
	public Course_Type() {
		super();
	}

	public Course_Type(int course_type_id, String course_type_name, String course_type_code, Date created_date,
			Date modified_date) {
		super();
		this.course_type_id = course_type_id;
		this.course_type_name = course_type_name;
		this.course_type_code = course_type_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	public int getCourse_type_id() {
		return course_type_id;
	}

	public void setCourse_type_id(int course_type_id) {
		this.course_type_id = course_type_id;
	}

	public String getCourse_type_name() {
		return course_type_name;
	}

	public void setCourse_type_name(String course_type_name) {
		this.course_type_name = course_type_name;
	}

	public String getCourse_type_code() {
		return course_type_code;
	}

	public void setCourse_type_code(String course_type_code) {
		this.course_type_code = course_type_code;
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
