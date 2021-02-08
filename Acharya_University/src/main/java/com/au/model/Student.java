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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_au_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	
	@Column(nullable = false)
	private String auid;
	
	@Column(nullable = false)	
	private String student_f_name;

	@Column(nullable = false)
	private String student_l_name;
	
	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	
	@Column(nullable = false)
	private String phone_no;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date doa;
	
	@Column(name = "created_Date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;

	@Column(nullable = false)
	private int school_id;//FK

	
	
	public Student() {
		super();
	}

	public Student(String auid, String student_f_name, String student_l_name, String address, Date dob, String phone_no,
			@Email String email, Date doa, Date created_Date, Date modified_Date, int school_id) {
		super();
		this.auid = auid;
		this.student_f_name = student_f_name;
		this.student_l_name = student_l_name;
		this.address = address;
		this.dob = dob;
		this.phone_no = phone_no;
		this.email = email;
		this.doa = doa;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
		this.school_id = school_id;
	}

	public Student(int student_id, String auid, String student_f_name, String student_l_name, String address, Date dob,
			String phone_no, @Email String email, Date doa, Date created_Date, Date modified_Date, int school_id) {
		super();
		this.student_id = student_id;
		this.auid = auid;
		this.student_f_name = student_f_name;
		this.student_l_name = student_l_name;
		this.address = address;
		this.dob = dob;
		this.phone_no = phone_no;
		this.email = email;
		this.doa = doa;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
		this.school_id = school_id;
	}

	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the auid
	 */
	public String getAuid() {
		return auid;
	}

	/**
	 * @param auid the auid to set
	 */
	public void setAuid(String auid) {
		this.auid = auid;
	}

	/**
	 * @return the student_f_name
	 */
	public String getStudent_f_name() {
		return student_f_name;
	}

	/**
	 * @param student_f_name the student_f_name to set
	 */
	public void setStudent_f_name(String student_f_name) {
		this.student_f_name = student_f_name;
	}

	/**
	 * @return the student_l_name
	 */
	public String getStudent_l_name() {
		return student_l_name;
	}

	/**
	 * @param student_l_name the student_l_name to set
	 */
	public void setStudent_l_name(String student_l_name) {
		this.student_l_name = student_l_name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the phone_no
	 */
	public String getPhone_no() {
		return phone_no;
	}

	/**
	 * @param phone_no the phone_no to set
	 */
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the doa
	 */
	public Date getDoa() {
		return doa;
	}

	/**
	 * @param doa the doa to set
	 */
	public void setDoa(Date doa) {
		this.doa = doa;
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
	
}
