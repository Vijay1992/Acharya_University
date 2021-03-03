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
@Table(name = "tbl_au_fee_admission_category")
public class FeeAdmissionCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fee_admission_category_id;
	private String fee_admission_category_type;
	private String fee_admission_category_short_name;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_date;

	private Integer created_by;
	private Integer modified_by;
	private Boolean active;
	private Boolean is_check;
	private String sub_category_applicable;

	public Integer getFee_admission_category_id() {
		return fee_admission_category_id;
	}

	public void setFee_admission_category_id(Integer fee_admission_category_id) {
		this.fee_admission_category_id = fee_admission_category_id;
	}

	public String getFee_admission_category_type() {
		return fee_admission_category_type;
	}

	public void setFee_admission_category_type(String fee_admission_category_type) {
		this.fee_admission_category_type = fee_admission_category_type;
	}

	public String getFee_admission_category_short_name() {
		return fee_admission_category_short_name;
	}

	public void setFee_admission_category_short_name(String fee_admission_category_short_name) {
		this.fee_admission_category_short_name = fee_admission_category_short_name;
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

	public Boolean getIs_check() {
		return is_check;
	}

	public void setIs_check(Boolean is_check) {
		this.is_check = is_check;
	}

	public String getSub_category_applicable() {
		return sub_category_applicable;
	}

	public void setSub_category_applicable(String sub_category_applicable) {
		this.sub_category_applicable = sub_category_applicable;
	}

}
