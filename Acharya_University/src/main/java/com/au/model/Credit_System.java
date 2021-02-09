package com.au.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_au_creditsystem")
public class Credit_System {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int credit_system_id;
	
	@Column(nullable = false)
	private char grade;
	
	@NotNull
	private Integer min_marks;
	
	@NotNull
	private Integer max_marks;
	
	@NotNull
	private Integer grade_points;

	@Column(nullable = false)
	private String performance;
	
	public Credit_System() {
		super();
	}

	//setters and getters for properties of Credit_System - class
	
	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public int getCredit_system_id() {
		return credit_system_id;
	}

	public void setCredit_system_id(int credit_system_id) {
		this.credit_system_id = credit_system_id;
	}

	
	public Integer getMin_marks() {
		return min_marks;
	}

	public void setMin_marks(Integer min_marks) {
		this.min_marks = min_marks;
	}

	public Integer getMax_marks() {
		return max_marks;
	}

	public void setMax_marks(Integer max_marks) {
		this.max_marks = max_marks;
	}

	public Integer getGrade_points() {
		return grade_points;
	}

	public void setGrade_points(Integer grade_points) {
		this.grade_points = grade_points;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
