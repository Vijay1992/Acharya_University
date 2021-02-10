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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_au_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;

	@NotBlank
	private String auid;

	@NotBlank
	private String student_f_name;

	@NotBlank
	private String student_l_name;

	@NotBlank
	private String address;

	@NotBlank
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;

	@NotBlank
	private String phone_no;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date doa;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;

	@NotNull
	private Integer school_id;// FK

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getAuid() {
		return auid;
	}

	public void setAuid(String auid) {
		this.auid = auid;
	}

	public String getStudent_f_name() {
		return student_f_name;
	}

	public void setStudent_f_name(String student_f_name) {
		this.student_f_name = student_f_name;
	}

	public String getStudent_l_name() {
		return student_l_name;
	}

	public void setStudent_l_name(String student_l_name) {
		this.student_l_name = student_l_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoa() {
		return doa;
	}

	public void setDoa(Date doa) {
		this.doa = doa;
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

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

}
