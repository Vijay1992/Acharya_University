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
@Table(name = "tbl_au_credit_category")
public class Credit_Category 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int credit_category_id;
	
	private int course_category_id; //FK
	
	private int credit_percentage;
	private int min_credits;
	
	@Column(name = "created_Date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created_Date;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modified_Date;

	public Credit_Category() {
		super();
	}

	public Credit_Category(int course_category_id, int credit_percentage, int min_credits, Date created_Date,
			Date modified_Date) {
		super();
		this.course_category_id = course_category_id;
		this.credit_percentage = credit_percentage;
		this.min_credits = min_credits;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
	}

	public Credit_Category(int credit_category_id, int course_category_id, int credit_percentage, int min_credits,
			Date created_Date, Date modified_Date) {
		super();
		this.credit_category_id = credit_category_id;
		this.course_category_id = course_category_id;
		this.credit_percentage = credit_percentage;
		this.min_credits = min_credits;
		this.created_Date = created_Date;
		this.modified_Date = modified_Date;
	}

	/**
	 * @return the credit_category_id
	 */
	public int getCredit_category_id() {
		return credit_category_id;
	}

	/**
	 * @param credit_category_id the credit_category_id to set
	 */
	public void setCredit_category_id(int credit_category_id) {
		this.credit_category_id = credit_category_id;
	}

	/**
	 * @return the course_category_id
	 */
	public int getCourse_category_id() {
		return course_category_id;
	}

	/**
	 * @param course_category_id the course_category_id to set
	 */
	public void setCourse_category_id(int course_category_id) {
		this.course_category_id = course_category_id;
	}

	/**
	 * @return the credit_percentage
	 */
	public int getCredit_percentage() {
		return credit_percentage;
	}

	/**
	 * @param credit_percentage the credit_percentage to set
	 */
	public void setCredit_percentage(int credit_percentage) {
		this.credit_percentage = credit_percentage;
	}

	/**
	 * @return the min_credits
	 */
	public int getMin_credits() {
		return min_credits;
	}

	/**
	 * @param min_credits the min_credits to set
	 */
	public void setMin_credits(int min_credits) {
		this.min_credits = min_credits;
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

	@Override
	public String toString() {
		return "Credit_Category [credit_category_id=" + credit_category_id + ", course_category_id="
				+ course_category_id + ", credit_percentage=" + credit_percentage + ", min_credits=" + min_credits
				+ ", created_Date=" + created_Date + ", modified_Date=" + modified_Date + "]";
	}
	
	
	
}
