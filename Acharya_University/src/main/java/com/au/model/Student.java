package com.au.model;

import java.util.Date;

import javax.persistence.Basic;
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
	private Integer student_id;
	private String auid;
	private String student_f_name;
	private String student_l_name;
	private String address;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	private String phone_no;
	@Email
	private String email;
	//@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Basic
	@Temporal(TemporalType.DATE)
	private Date doa;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;
	private Integer school_id;// FK

	/*
	 * private Integer student_id; private String student_name; private String
	 * father_name; private String mother_name; private String guardian_name;
	 * private String correspondance_address; private String permanent_address;
	 * private String auid; private Date created_date; private Date modified_date;
	 * private Date doa; private Date dob; private Integer phone_no; private Integer
	 * stu_mobile_no; private Integer father_mobile_no; private Integer
	 * mother_mobile_no; private Integer guardian_mobile_no; private String
	 * stu_email; private String father_email; private String mother_email; private
	 * String guardian_email; private String student_f_name; private String
	 * student_l_name; private Integer school_id; private String nationality;
	 * private String religion; private String aadharcard; private String
	 * joining_semester;
	 */
	
}
