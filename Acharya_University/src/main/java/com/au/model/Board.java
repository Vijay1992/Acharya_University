package com.au.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_au_board")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer board_unique_id;
	private String board_unique_name;
	private String 	board_unique_short_name;
	
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
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name ="school_id",referencedColumnName = "school_id" )
	private Schools sch;//fk
	
	
	public Board() {
		super();
	}

	public Board(Integer board_unique_id, String board_unique_name, String board_unique_short_name, Date created_date,
			Date modified_date, Integer created_by, Integer modified_by) {
		super();
		this.board_unique_id = board_unique_id;
		this.board_unique_name = board_unique_name;
		this.board_unique_short_name = board_unique_short_name;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_by = created_by;
		this.modified_by = modified_by;
	}

	public Integer getBoard_unique_id() {
		return board_unique_id;
	}

	public void setBoard_unique_id(Integer board_unique_id) {
		this.board_unique_id = board_unique_id;
	}

	public String getBoard_unique_name() {
		return board_unique_name;
	}

	public void setBoard_unique_name(String board_unique_name) {
		this.board_unique_name = board_unique_name;
	}

	public String getBoard_unique_short_name() {
		return board_unique_short_name;
	}

	public void setBoard_unique_short_name(String board_unique_short_name) {
		this.board_unique_short_name = board_unique_short_name;
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
	}