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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_credit_category")
public class CreditCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int credit_category_id;
	@NotNull
	private Integer course_category_id; // FK
	@NotNull
	private Integer credit_percentage;
	@NotNull
	private Integer min_credits;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;

	public int getCredit_category_id() {
		return credit_category_id;
	}

	public void setCredit_category_id(int credit_category_id) {
		this.credit_category_id = credit_category_id;
	}

	public Integer getCourse_category_id() {
		return course_category_id;
	}

	public void setCourse_category_id(Integer course_category_id) {
		this.course_category_id = course_category_id;
	}

	public Integer getCredit_percentage() {
		return credit_percentage;
	}

	public void setCredit_percentage(Integer credit_percentage) {
		this.credit_percentage = credit_percentage;
	}

	public Integer getMin_credits() {
		return min_credits;
	}

	public void setMin_credits(Integer min_credits) {
		this.min_credits = min_credits;
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

}
