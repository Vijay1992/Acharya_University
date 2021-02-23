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
@Table(name = "tbl_au_graduation_type")
public class Graduation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer graduation_id;
	
	private String graduation_name;
	private String graduation_name_short;
	
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	
	private int created_by;
	private int modified_by;
	private boolean active;
	
	public Graduation() {
		super();
	}
	
	public Graduation(Integer graduation_id, String graduation_name, String graduation_name_short, Date created_date,
			Date modified_date, int created_by, int modified_by, boolean active) {
		super();
		this.graduation_id = graduation_id;
		this.graduation_name = graduation_name;
		this.graduation_name_short = graduation_name_short;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.active = active;
	}

	public Integer getGraduation_id() {
		return graduation_id;
	}

	public void setGraduation_id(Integer graduation_id) {
		this.graduation_id = graduation_id;
	}

	public String getGraduation_name() {
		return graduation_name;
	}

	public void setGraduation_name(String graduation_name) {
		this.graduation_name = graduation_name;
	}

	public String getGraduation_name_short() {
		return graduation_name_short;
	}

	public void setGraduation_name_short(String graduation_name_short) {
		this.graduation_name_short = graduation_name_short;
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

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getModified_by() {
		return modified_by;
	}

	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
