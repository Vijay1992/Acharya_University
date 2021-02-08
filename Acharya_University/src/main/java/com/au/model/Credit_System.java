package com.au.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_au_creditsystem")
public class Credit_System {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int credit_system_id;
	private String grade;
	private int min_marks;
	private int max_marks;
	private int grade_points;
	
	private String performance;

	
	//setters and getters for properties of Credit_System - class
	
	/**
	 * @return the credit_system_id
	 */
	public int getCredit_system_id() {
		return credit_system_id;
	}

	/**
	 * @param credit_system_id the credit_system_id to set
	 */
	public void setCredit_system_id(int credit_system_id) {
		this.credit_system_id = credit_system_id;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the min_marks
	 */
	public int getMin_marks() {
		return min_marks;
	}

	/**
	 * @param min_marks the min_marks to set
	 */
	public void setMin_marks(int min_marks) {
		this.min_marks = min_marks;
	}

	/**
	 * @return the max_marks
	 */
	public int getMax_marks() {
		return max_marks;
	}

	/**
	 * @param max_marks the max_marks to set
	 */
	public void setMax_marks(int max_marks) {
		this.max_marks = max_marks;
	}

	/**
	 * @return the grade_points
	 */
	public int getGrade_points() {
		return grade_points;
	}

	/**
	 * @param grade_points the grade_points to set
	 */
	public void setGrade_points(int grade_points) {
		this.grade_points = grade_points;
	}

	/**
	 * @return the performance
	 */
	public String getPerformance() {
		return performance;
	}

	/**
	 * @param performance the performance to set
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
	
	
}
