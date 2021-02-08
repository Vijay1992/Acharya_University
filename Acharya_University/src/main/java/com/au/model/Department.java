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
@Table(name = "tbl_au_dept")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int dept_id;

	@Column(name = "dept_name")
	private String dept_name;

	@Column(name = "dept_code")
	private String dept_code;

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;

	private int school_id;	//FK
	
	public Department() {
		super();
	}

	public Department(String dept_name, String dept_code, Date created_date, Date modified_date) {
		super();
		this.dept_name = dept_name;
		this.dept_code = dept_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	public Department(int dept_id, String dept_name, String dept_code, Date created_date, Date modified_date) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_code = dept_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
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

	
	

	/**
	 * @return the school_id
	 */
	public int getSchool_id() {
		return school_id;
	}

	/**
	 * @param school_id the school_id to set
	 */
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_code=" + dept_code
				+ ", created_date=" + created_date + ", modified_date=" + modified_date + "]";
	}

}
