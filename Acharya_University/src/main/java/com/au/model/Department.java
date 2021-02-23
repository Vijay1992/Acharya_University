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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_dept")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dept_id;
	private String dept_name;
	private String dept_code;

	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	private String dept_name_short;
	private String duration;
	
	
	
	private Integer school_id;	//FK
	private Integer graduation_id;	//FK
	private Integer created_by;
	private Integer modified_by;
	private boolean active;
	private Integer tag_id;
	private Integer service_oriented;
	private Integer priority;
	
	public Department() {
		super();
	}

	public Department(int dept_id, String dept_name, String dept_code, Date created_date, Date modified_date,
			String dept_name_short, String duration, Integer school_id, Integer graduation_id, Integer created_by,
			Integer modified_by, boolean active, Integer tag_id, Integer service_oriented, Integer priority) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_code = dept_code;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.dept_name_short = dept_name_short;
		this.duration = duration;
		this.school_id = school_id;
		this.graduation_id = graduation_id;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.active = active;
		this.tag_id = tag_id;
		this.service_oriented = service_oriented;
		this.priority = priority;
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

	public String getDept_name_short() {
		return dept_name_short;
	}

	public void setDept_name_short(String dept_name_short) {
		this.dept_name_short = dept_name_short;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getGraduation_id() {
		return graduation_id;
	}

	public void setGraduation_id(Integer graduation_id) {
		this.graduation_id = graduation_id;
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

	public Integer getTag_id() {
		return tag_id;
	}

	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}

	public Integer getService_oriented() {
		return service_oriented;
	}

	public void setService_oriented(Integer service_oriented) {
		this.service_oriented = service_oriented;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
	
	
}