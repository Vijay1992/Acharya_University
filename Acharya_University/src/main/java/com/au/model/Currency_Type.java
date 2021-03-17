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
@Table(name = "tbl_au_currency_type")
public class Currency_Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer currency_type_id;
	private String currency_type_name;
	private String currency_type_short_name;
	
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
	private boolean active;
	public Currency_Type() {
		super();
	}
	public Currency_Type(Integer currency_type_id, String currency_type_name, String currency_type_short_name,
			Date created_date, Date modified_date, Integer created_by, Integer modified_by, boolean active) {
		super();
		this.currency_type_id = currency_type_id;
		this.currency_type_name = currency_type_name;
		this.currency_type_short_name = currency_type_short_name;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.active = active;
	}
	public Integer getCurrency_type_id() {
		return currency_type_id;
	}
	public void setCurrency_type_id(Integer currency_type_id) {
		this.currency_type_id = currency_type_id;
	}
	public String getCurrency_type_name() {
		return currency_type_name;
	}
	public void setCurrency_type_name(String currency_type_name) {
		this.currency_type_name = currency_type_name;
	}
	public String getCurrency_type_short_name() {
		return currency_type_short_name;
	}
	public void setCurrency_type_short_name(String currency_type_short_name) {
		this.currency_type_short_name = currency_type_short_name;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
}
