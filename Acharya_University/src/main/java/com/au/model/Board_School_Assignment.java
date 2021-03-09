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
@Table(name = "tbl_au_board_school_assignment")
public class Board_School_Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer board_school_assignment_id;
	
	private Integer board_id;//fk
	private Integer school_id; //fk
	
	@Column(name = "created_date",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)	
	@CreationTimestamp
	private Date created_date;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)	
	@UpdateTimestamp
	private Date modified_date;
	private boolean active;
	
	public Board_School_Assignment() {
		super();
	}
	
	
	
	public Board_School_Assignment(Integer board_school_assignment_id, Integer board_id, Integer school_id,
			Date created_date, Date modified_date, boolean active) {
		super();
		this.board_school_assignment_id = board_school_assignment_id;
		this.board_id = board_id;
		this.school_id = school_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
	}



	public Integer getBoard_school_assignment_id() {
		return board_school_assignment_id;
	}
	public void setBoard_school_assignment_id(Integer board_school_assignment_id) {
		this.board_school_assignment_id = board_school_assignment_id;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
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



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
