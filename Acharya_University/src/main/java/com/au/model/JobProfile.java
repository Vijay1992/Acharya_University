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


@Entity
@Table(name = "tbl_au_job_profile")
public class JobProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer job_id;
	private String first_name;
	private String last_name;
	private String gender;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	private String father_name;
	private String mobile;
	private String residential_contact_no;
	@Email()
	private String email;
	private String martial_status;
	private String spouse_name;
	private String door_no;
	private String building;
	private String street;
	private String locality;
	private String city;
	private String state;
	private Integer pincode;
	private String permanent_address;
	private String key_skills;
	private Integer exp_in_years;
	private Integer exp_in_months;
	private Integer annual_salary_lakhs; // last_ctc
	private String resume_headline;
	private String department_choice;
	private Boolean applied_before;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date earlier_applied_date;
	private String earlier_applied_position;
	private Boolean refer_by_acharya_emp;
	private String name_dep;
	private String acharyan_contact;
	private Boolean refer_by_any;
	private String reference_name_dept;
	private String reference_contact;
	private String current_location; // (combination of door+building+street+locality)
	private String reference_no;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;
	private String hod_comment;
	private Boolean active;

	public JobProfile() {
		super();
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getResidential_contact_no() {
		return residential_contact_no;
	}

	public void setResidential_contact_no(String residential_contact_no) {
		this.residential_contact_no = residential_contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMartial_status() {
		return martial_status;
	}

	public void setMartial_status(String martial_status) {
		this.martial_status = martial_status;
	}

	public String getSpouse_name() {
		return spouse_name;
	}

	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}

	public String getDoor_no() {
		return door_no;
	}

	public void setDoor_no(String door_no) {
		this.door_no = door_no;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getKey_skills() {
		return key_skills;
	}

	public void setKey_skills(String key_skills) {
		this.key_skills = key_skills;
	}

	public Integer getExp_in_years() {
		return exp_in_years;
	}

	public void setExp_in_years(Integer exp_in_years) {
		this.exp_in_years = exp_in_years;
	}

	public Integer getExp_in_months() {
		return exp_in_months;
	}

	public void setExp_in_months(Integer exp_in_months) {
		this.exp_in_months = exp_in_months;
	}

	public Integer getAnnual_salary_lakhs() {
		return annual_salary_lakhs;
	}

	public void setAnnual_salary_lakhs(Integer annual_salary_lakhs) {
		this.annual_salary_lakhs = annual_salary_lakhs;
	}

	public String getResume_headline() {
		return resume_headline;
	}

	public void setResume_headline(String resume_headline) {
		this.resume_headline = resume_headline;
	}

	public String getDepartment_choice() {
		return department_choice;
	}

	public void setDepartment_choice(String department_choice) {
		this.department_choice = department_choice;
	}

	public Boolean getApplied_before() {
		return applied_before;
	}

	public void setApplied_before(Boolean applied_before) {
		this.applied_before = applied_before;
	}

	public Date getEarlier_applied_date() {
		return earlier_applied_date;
	}

	public void setEarlier_applied_date(Date earlier_applied_date) {
		this.earlier_applied_date = earlier_applied_date;
	}

	public String getEarlier_applied_position() {
		return earlier_applied_position;
	}

	public void setEarlier_applied_position(String earlier_applied_position) {
		this.earlier_applied_position = earlier_applied_position;
	}

	public Boolean getRefer_by_acharya_emp() {
		return refer_by_acharya_emp;
	}

	public void setRefer_by_acharya_emp(Boolean refer_by_acharya_emp) {
		this.refer_by_acharya_emp = refer_by_acharya_emp;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getAcharyan_contact() {
		return acharyan_contact;
	}

	public void setAcharyan_contact(String acharyan_contact) {
		this.acharyan_contact = acharyan_contact;
	}

	public Boolean getRefer_by_any() {
		return refer_by_any;
	}

	public void setRefer_by_any(Boolean refer_by_any) {
		this.refer_by_any = refer_by_any;
	}

	public String getReference_name_dept() {
		return reference_name_dept;
	}

	public void setReference_name_dept(String reference_name_dept) {
		this.reference_name_dept = reference_name_dept;
	}

	public String getReference_contact() {
		return reference_contact;
	}

	public void setReference_contact(String reference_contact) {
		this.reference_contact = reference_contact;
	}

	public String getCurrent_location() {
		return current_location;
	}

	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
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

	public String getHod_comment() {
		return hod_comment;
	}

	public void setHod_comment(String hod_comment) {
		this.hod_comment = hod_comment;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
