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
@Table(name = "tbl_au_year_sem")
public class Year_Sem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sem_id")
	private int sem_id;
	
	private String semister;
	
	private int year_id;
	
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;

	/**
	 * 
	 */
	public Year_Sem() {
	}

	/**
	 * @param semister
	 * @param year_id
	 * @param created_date
	 * @param modified_date
	 */
	public Year_Sem(String semister, int year_id, Date created_date, Date modified_date) {
		this.semister = semister;
		this.year_id = year_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	/**
	 * @param sem_id
	 * @param semister
	 * @param year_id
	 * @param created_date
	 * @param modified_date
	 */
	public Year_Sem(int sem_id, String semister, int year_id, Date created_date, Date modified_date) {
		this.sem_id = sem_id;
		this.semister = semister;
		this.year_id = year_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}

	/**
	 * @return the sem_id
	 */
	public int getSem_id() {
		return sem_id;
	}

	/**
	 * @param sem_id the sem_id to set
	 */
	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}

	/**
	 * @return the semister
	 */
	public String getSemister() {
		return semister;
	}

	/**
	 * @param semister the semister to set
	 */
	public void setSemister(String semister) {
		this.semister = semister;
	}

	/**
	 * @return the year_id
	 */
	public int getYear_id() {
		return year_id;
	}

	/**
	 * @param year_id the year_id to set
	 */
	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}

	/**
	 * @return the created_date
	 */
	public Date getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	/**
	 * @return the modified_date
	 */
	public Date getModified_date() {
		return modified_date;
	}

	/**
	 * @param modified_date the modified_date to set
	 */
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "Year_Sem [sem_id=" + sem_id + ", semister=" + semister + ", year_id=" + year_id + ", created_date="
				+ created_date + ", modified_date=" + modified_date + "]";
	}
	
}
