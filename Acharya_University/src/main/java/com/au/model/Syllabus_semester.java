package com.au.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_au_syllabus_semester")
public class Syllabus_semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "syllabus_sem_id")
	
	private int syllabus_sem_id;
	private int year_id;
	private int sem_id;
	private int course_id;
	/**
	 * @return the syllabus_sem_id
	 */
	public int getSyllabus_sem_id() {
		return syllabus_sem_id;
	}
	/**
	 * @param syllabus_sem_id the syllabus_sem_id to set
	 */
	public void setSyllabus_sem_id(int syllabus_sem_id) {
		this.syllabus_sem_id = syllabus_sem_id;
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
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}
	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
	
}
