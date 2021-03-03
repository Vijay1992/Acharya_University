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
@Table(name = "tbl_au_group")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer group_id;
	private String group_name;
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	private Integer created_by;
	private Integer modified_by;
	private Boolean active;
	private String remarks;
	private Integer group_priority;
	
	
	
	public Group() {
		super();
	}



	public Group(Integer group_id, String group_name, Date created_date, Date modified_date, Integer created_by,
			Integer modified_by, Boolean active, String remarks, Integer group_priority) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.active = active;
		this.remarks = remarks;
		this.group_priority = group_priority;
	}



	public Integer getGroup_id() {
		return group_id;
	}



	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}



	public String getGroup_name() {
		return group_name;
	}



	public void setGroup_name(String group_name) {
		this.group_name = group_name;
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



	public Boolean getActive() {
		return active;
	}



	public void setActive(Boolean active) {
		this.active = active;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public Integer getGroup_priority() {
		return group_priority;
	}



	public void setGroup_priority(Integer group_priority) {
		this.group_priority = group_priority;
	}
	
	
	
	
}
